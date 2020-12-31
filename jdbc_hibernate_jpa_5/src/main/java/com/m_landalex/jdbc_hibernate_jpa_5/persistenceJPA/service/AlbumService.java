package com.m_landalex.jdbc_hibernate_jpa_5.persistenceJPA.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.m_landalex.jdbc_hibernate_jpa_5.data.Album;
import com.m_landalex.jdbc_hibernate_jpa_5.mapper.AlbumMapper;
import com.m_landalex.jdbc_hibernate_jpa_5.persistenceJPA.repository.AlbumRepository;

@Service("albumServiceJPA")
public class AlbumService {

	@Autowired
	private AlbumRepository albumRepository;
	@Autowired
	private AlbumMapper albumMapper;
	
	public Album save(Album album) {
		albumRepository.save(albumMapper.toEntity(album));
		return album;
	}
	
	@Transactional(readOnly = true)
	public List<Album> fetchAll(){
		List<Album> returnedAlbumList = albumMapper.toObjectList(albumRepository.findAll());
		returnedAlbumList.forEach(System.out::println);
		return returnedAlbumList;
	}
	
}
