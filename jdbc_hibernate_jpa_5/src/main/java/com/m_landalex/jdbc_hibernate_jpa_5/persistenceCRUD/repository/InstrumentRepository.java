package com.m_landalex.jdbc_hibernate_jpa_5.persistenceCRUD.repository;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.m_landalex.jdbc_hibernate_jpa_5.data.Instrument;
import com.m_landalex.jdbc_hibernate_jpa_5.domain.InstrumentEntity;

public interface InstrumentRepository extends CrudRepository<InstrumentEntity, Long> {

	@Transactional(readOnly = true)
	Collection<InstrumentEntity> findByInstrumentContainingIgnoreCase(String partInstrumentName);
	@Transactional(readOnly = true)
	Collection<InstrumentEntity> findAll();
	@Transactional(readOnly = true)
	Collection<Instrument> findAllById(Collection<Long> ids);
	
}