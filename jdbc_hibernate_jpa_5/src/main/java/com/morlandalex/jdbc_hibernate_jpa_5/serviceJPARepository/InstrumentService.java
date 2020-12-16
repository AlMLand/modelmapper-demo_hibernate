package com.morlandalex.jdbc_hibernate_jpa_5.serviceJPARepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.morlandalex.jdbc_hibernate_jpa_5.data.Instrument;
import com.morlandalex.jdbc_hibernate_jpa_5.domain.InstrumentEntity;
import com.morlandalex.jdbc_hibernate_jpa_5.persistenceJPARepository.InstrumentRepository;

@Service("instrumentServiceJPA")
public class InstrumentService {

	@Autowired
	private InstrumentRepository instrumentRepository;
	
	@Transactional
	public Instrument save(Instrument instrument) {
		instrumentRepository.save(ObjectMapperUtils.map(instrument, InstrumentEntity.class));
		return instrument;
	}
	
	public List<Instrument> fetchAll(){
		List<Instrument> returnedInstrumentList = ObjectMapperUtils.mapAll(instrumentRepository.findAll(), Instrument.class);
		returnedInstrumentList.forEach(System.out::println);
		return returnedInstrumentList;
	}
	
}
