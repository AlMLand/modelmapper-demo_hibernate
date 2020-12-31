package com.morlandalex.jdbc_hibernate_jpa_5.serviceJPArepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.morlandalex.jdbc_hibernate_jpa_5.data.Instrument;
import com.morlandalex.jdbc_hibernate_jpa_5.mapper.InstrumentMapper;
import com.morlandalex.jdbc_hibernate_jpa_5.persistenceJPArepository.InstrumentRepository;

@Service("instrumentServiceJPA")
public class InstrumentService {

	@Autowired
	private InstrumentRepository instrumentRepository;
	@Autowired
	private InstrumentMapper instrumentMapper;
	
	public Instrument save(Instrument instrument) {
		instrumentRepository.save(instrumentMapper.toEntity(instrument));
		return instrument;
	}

	@Transactional(readOnly = true)
	public List<Instrument> fetchAll(){
		List<Instrument> returnedInstrumentList = instrumentMapper.toObjectList(instrumentRepository.findAll());
		returnedInstrumentList.forEach(System.out::println);
		return returnedInstrumentList;
	}
	
}
