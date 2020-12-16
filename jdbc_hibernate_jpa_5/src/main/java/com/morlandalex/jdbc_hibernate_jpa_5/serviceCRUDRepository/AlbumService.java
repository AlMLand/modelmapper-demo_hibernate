package com.morlandalex.jdbc_hibernate_jpa_5.serviceCRUDRepository;

import java.util.Collection;

import com.morlandalex.jdbc_hibernate_jpa_5.data.Album;

public interface AlbumService {

	Collection<Album> fetchByTitle(String title);
	<A extends Album> A save(A album);
	<A extends Album> Collection<A> saveAll(Collection<A> albums);
	Album fetchById(Long id);
	boolean existsById(Long id);
	Collection<Album> fetchAll();
	Collection<Album> fetchAllById(Collection<Long> ids);
	long count();
	void deleteById(Long id);
	void delete(Album album);
	void deleteAll(Collection<? extends Album> albums);
	void deleteAll();
	
}
