package com.m_landalex.jdbc_hibernate_jpa_5.mapper;

import java.util.List;

import com.m_landalex.jdbc_hibernate_jpa_5.data.AbstractObject;
import com.m_landalex.jdbc_hibernate_jpa_5.domain.AuditableEntity;

public interface Mapper<E extends AbstractObject, D extends AuditableEntity<?>> {

	D toEntity(E dto);
	E toObject(D entity);
	List<E> toObjectList(List<D> entities);
	
}
