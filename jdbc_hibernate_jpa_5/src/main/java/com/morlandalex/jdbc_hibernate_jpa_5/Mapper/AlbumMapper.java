package com.morlandalex.jdbc_hibernate_jpa_5.Mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.morlandalex.jdbc_hibernate_jpa_5.data.Album;
import com.morlandalex.jdbc_hibernate_jpa_5.domain.AlbumEntity;

@Component("albumMapper")
public class AlbumMapper extends AbstractMapper<Album, AlbumEntity> {

	@Autowired
	public AlbumMapper() {
		super(Album.class, AlbumEntity.class);
	}

}
