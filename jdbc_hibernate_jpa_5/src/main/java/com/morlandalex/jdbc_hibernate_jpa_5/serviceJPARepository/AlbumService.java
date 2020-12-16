package com.morlandalex.jdbc_hibernate_jpa_5.serviceJPARepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.morlandalex.jdbc_hibernate_jpa_5.data.Album;
import com.morlandalex.jdbc_hibernate_jpa_5.domain.AlbumEntity;
import com.morlandalex.jdbc_hibernate_jpa_5.persistenceJPARepository.AlbumRepository;

@Service("albumServiceJPA")
public class AlbumService {

	@Autowired
	private AlbumRepository albumRepository;
	
	@Transactional
	public Album save(Album album) {
		albumRepository.save(ObjectMapperUtils.map(album, AlbumEntity.class));
		return album;
	}
	
	public List<Album> fetchAll(){
		List<Album> returnedAlbumList = ObjectMapperUtils.mapAll(albumRepository.findAll(), Album.class);
		returnedAlbumList.forEach(System.out::println);
		return returnedAlbumList;
	}
	
}
