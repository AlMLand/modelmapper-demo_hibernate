package com.morlandalex.jdbc_hibernate_jpa_5.persistenceJPARepository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.morlandalex.jdbc_hibernate_jpa_5.data.SingerSummary;
import com.morlandalex.jdbc_hibernate_jpa_5.domain.SingerEntity;

public interface SingerRepository extends JpaRepository<SingerEntity, Long> {

	List<SingerEntity> findByLastNameIgnoreCaseOrderByFirstName(String lastName);
	
	@Query("SELECT s FROM SingerEntity s WHERE s.birthDate=:birthDate")
	List<SingerEntity> findByBirthDate(@Param("birthDate")LocalDate date);
	
	@Query("SELECT new com.morlandalex.jdbc_hibernate_jpa_5.data.SingerSummary(s.firstName, s.lastName, a.title) FROM SingerEntity s "
			+ "LEFT JOIN s.albums a WHERE a.releaseDate=(SELECT max(a2.releaseDate) FROM AlbumEntity a2 WHERE a2.singerId.id=s.id) ORDER BY s.id")
	List<SingerSummary> findAllSingerSummary();
	
	@Query("SELECT new com.morlandalex.jdbc_hibernate_jpa_5.data.SingerSummary(s.firstName, s.lastName, a.title) FROM SingerEntity s "
			+ "LEFT JOIN s.albums a WHERE a.releaseDate=(SELECT max(a2.releaseDate) FROM AlbumEntity a2 WHERE a2.singerId.id=s.id) AND s.id=:id")
	SingerSummary findByIdSingerSummary(@Param("id")Long singerId);
	
}
