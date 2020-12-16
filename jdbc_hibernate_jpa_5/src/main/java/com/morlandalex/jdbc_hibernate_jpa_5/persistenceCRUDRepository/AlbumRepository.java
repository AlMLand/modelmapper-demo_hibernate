package com.morlandalex.jdbc_hibernate_jpa_5.persistenceCRUDRepository;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.morlandalex.jdbc_hibernate_jpa_5.data.Album;
import com.morlandalex.jdbc_hibernate_jpa_5.domain.AlbumEntity;

public interface AlbumRepository extends CrudRepository<AlbumEntity, Long> {

	@Transactional(readOnly = true)
	Collection<AlbumEntity> findByTitle(String title);
	@Transactional(readOnly = true)
	Collection<AlbumEntity> findAll();
	@Transactional(readOnly = true)
	Collection<Album> findAllById(Collection<Long> ids);
	
}
