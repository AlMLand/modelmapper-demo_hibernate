package com.morlandalex.jdbc_hibernate_jpa_5.persistenceJPArepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.morlandalex.jdbc_hibernate_jpa_5.domain.AlbumEntity;

public interface AlbumRepository extends JpaRepository<AlbumEntity, Long> {

}
