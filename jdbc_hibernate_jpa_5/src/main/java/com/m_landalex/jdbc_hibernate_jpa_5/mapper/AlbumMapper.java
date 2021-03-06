package com.m_landalex.jdbc_hibernate_jpa_5.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.m_landalex.jdbc_hibernate_jpa_5.data.Album;
import com.m_landalex.jdbc_hibernate_jpa_5.domain.AlbumEntity;

@Component("albumMapper")
public class AlbumMapper extends AbstractMapper<Album, AlbumEntity> {

	@Autowired
	public AlbumMapper() {
		super(Album.class, AlbumEntity.class);
	}

}
