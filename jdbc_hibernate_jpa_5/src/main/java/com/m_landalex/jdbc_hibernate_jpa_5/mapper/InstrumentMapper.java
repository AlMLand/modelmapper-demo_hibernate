package com.m_landalex.jdbc_hibernate_jpa_5.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.m_landalex.jdbc_hibernate_jpa_5.data.Instrument;
import com.m_landalex.jdbc_hibernate_jpa_5.domain.InstrumentEntity;

@Component("instrumentMapper")
public class InstrumentMapper extends AbstractMapper<Instrument, InstrumentEntity> {

	@Autowired
	public InstrumentMapper() {
		super(Instrument.class, InstrumentEntity.class);
	}

}
