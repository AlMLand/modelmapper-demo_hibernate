package com.m_landalex.jdbc_hibernate_jpa_5.persistenceCRUD.service;

import java.util.Collection;

import com.m_landalex.jdbc_hibernate_jpa_5.data.Instrument;

public interface InstrumentService {
	
	Collection<Instrument> fetchByInstrumentContainingIgnoreCase(String partInstrumentName);
	<I extends Instrument> I save(I instrument);
	<I extends Instrument> Collection<I> saveAll(Collection<I> instruments);
	Instrument fetchById(Long id);
	boolean existsById(Long id);
	Collection<Instrument> fetchAll();
	Collection<Instrument> fetchAllById(Collection<Long> ids);
	long count();
	void deleteById(Long id);
	void delete(Instrument instrument);
	void deleteAll(Collection<? extends Instrument> instruments);
	void deleteAll();

}
