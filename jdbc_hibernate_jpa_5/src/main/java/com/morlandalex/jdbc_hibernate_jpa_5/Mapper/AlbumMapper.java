package com.morlandalex.jdbc_hibernate_jpa_5.Mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.morlandalex.jdbc_hibernate_jpa_5.data.Album;
import com.morlandalex.jdbc_hibernate_jpa_5.domain.AlbumEntity;
import com.morlandalex.jdbc_hibernate_jpa_5.persistenceJPARepository.SingerRepository;

@Component("albumMapper")
public class AlbumMapper extends AbstractMapper<Album, AlbumEntity> {

	@Autowired
	public AlbumMapper(ModelMapper modelMapper, SingerRepository singerRepository) {
		super(Album.class, AlbumEntity.class);
	}

}
