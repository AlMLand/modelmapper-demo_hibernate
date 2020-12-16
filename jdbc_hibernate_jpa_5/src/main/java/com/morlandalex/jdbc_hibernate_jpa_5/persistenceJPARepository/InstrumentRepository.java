package com.morlandalex.jdbc_hibernate_jpa_5.persistenceJPARepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.morlandalex.jdbc_hibernate_jpa_5.domain.InstrumentEntity;

@Transactional(readOnly = true)
public interface InstrumentRepository extends JpaRepository<InstrumentEntity, Long> {

}
