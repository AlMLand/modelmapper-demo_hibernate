package com.m_landalex.jdbc_hibernate_jpa_5.persistenceJPA.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.m_landalex.jdbc_hibernate_jpa_5.domain.AlbumEntity;

public interface AlbumRepository extends JpaRepository<AlbumEntity, Long> {

}
