package com.morlandalex.jdbc_hibernate_jpa_5.serviceCRUDRepository;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.morlandalex.jdbc_hibernate_jpa_5.StaticMapper.ObjectMapperUtils;
import com.morlandalex.jdbc_hibernate_jpa_5.data.Album;
import com.morlandalex.jdbc_hibernate_jpa_5.domain.AlbumEntity;
import com.morlandalex.jdbc_hibernate_jpa_5.persistenceCRUDRepository.AlbumRepository;

@Service("albumService")
public class AlbumServiceImpl implements AlbumService {

	@Autowired(required = false)
	private AlbumRepository albumRepository;
	
	@Override
	public Collection<Album> fetchByTitle(String title) {
		Collection<Album> returnedIterableAlbum = ObjectMapperUtils.mapAll(albumRepository.findByTitle(title), Album.class);
		returnedIterableAlbum.forEach(System.out::println);
		return returnedIterableAlbum;
	}

	@Override
	public <A extends Album> A save(A album) {
		ObjectMapperUtils.map(album, AlbumEntity.class);
		return album;
	}

	@Override
	public <A extends Album> Collection<A> saveAll(Collection<A> albums) {
		albumRepository.saveAll(ObjectMapperUtils.mapAll(albums, AlbumEntity.class));
		return albums;
	}

	@Override
	public Album fetchById(Long id) {
		Album returnedAlbum = ObjectMapperUtils.map(albumRepository.findById(id), Album.class);
		System.out.println(returnedAlbum);
		return returnedAlbum;
	}

	@Override
	public boolean existsById(Long id) {
		return albumRepository.existsById(id);
	}

	@Override
	public Collection<Album> fetchAll() {
		Collection<Album> returnedIterableAlbum = ObjectMapperUtils.mapAll(albumRepository.findAll(), Album.class);
		returnedIterableAlbum.forEach(System.out::println);
		return returnedIterableAlbum;
	}

	@Override
	public Collection<Album> fetchAllById(Collection<Long> ids) {
		Collection<Album> returnedIterableAlbum = ObjectMapperUtils.mapAll(albumRepository.findAllById(ids), Album.class);
		returnedIterableAlbum.forEach(System.out::println);
		return returnedIterableAlbum;
	}

	@Override
	public long count() {
		return albumRepository.count();
	}

	@Override
	public void deleteById(Long id) {
		albumRepository.deleteById(id);
	}

	@Override
	public void delete(Album album) {
		albumRepository.delete(ObjectMapperUtils.map(album, AlbumEntity.class));
	}

	@Override
	public void deleteAll(Collection<? extends Album> albums) {
		albumRepository.deleteAll(ObjectMapperUtils.mapAll(albums, AlbumEntity.class));
	}

	@Override
	public void deleteAll() {
		albumRepository.deleteAll();
	}

}