package com.m_landalex.jdbc_hibernate_jpa_5.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.m_landalex.jdbc_hibernate_jpa_5.data.Singer;
import com.m_landalex.jdbc_hibernate_jpa_5.domain.SingerEntity;

@Component("singerMapper")
public class SingerMapper extends AbstractMapper<Singer, SingerEntity> {
	
	@Autowired
	public SingerMapper() {
		super(Singer.class, SingerEntity.class);
	}
	
}
