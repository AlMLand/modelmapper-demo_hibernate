package com.morlandalex.jdbc_hibernate_jpa_5.persistenceCRUDrepository;

import java.time.LocalDate;
import java.util.Collection;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.morlandalex.jdbc_hibernate_jpa_5.domain.SingerEntity;

@Transactional(readOnly = true)
public interface SingerRepository extends CrudRepository<SingerEntity, Long> {

	Collection<SingerEntity> findByFirstName(String firstName);
	Collection<SingerEntity> findByLastName(String lastName);
	Collection<SingerEntity> findByFirstNameAndLastName(String firstName, String lastName);
	Collection<SingerEntity> findByFirstNameContainingIgnoreCase(String partFirstName);
	Collection<SingerEntity> findByBirthDateGreaterThanEqual(LocalDate localDate);
	Collection<SingerEntity> findByBirthDateLessThanEqual(LocalDate localDate);
	Collection<SingerEntity> findAll();
	Collection<SingerEntity> findAllById(Collection<Long> ids);
	void deleteAll(Collection<? extends SingerEntity> singers);
	
}
