package com.morlandalex.jdbc_hibernate_jpa_5.persistenceJPARepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.morlandalex.jdbc_hibernate_jpa_5.domain.InstrumentEntity;

public interface InstrumentRepository extends JpaRepository<InstrumentEntity, Long> {

}
