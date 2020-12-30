package com.morlandalex.jdbc_hibernate_jpa_5.Mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.morlandalex.jdbc_hibernate_jpa_5.data.Instrument;
import com.morlandalex.jdbc_hibernate_jpa_5.domain.InstrumentEntity;

@Component("instrumentMapper")
public class InstrumentMapper extends AbstractMapper<Instrument, InstrumentEntity> {

	@Autowired
	public InstrumentMapper() {
		super(Instrument.class, InstrumentEntity.class);
	}

}
