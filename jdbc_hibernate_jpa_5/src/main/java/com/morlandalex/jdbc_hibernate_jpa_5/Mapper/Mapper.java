package com.morlandalex.jdbc_hibernate_jpa_5.Mapper;

import java.util.List;

import com.morlandalex.jdbc_hibernate_jpa_5.data.AbstractObject;
import com.morlandalex.jdbc_hibernate_jpa_5.domain.AuditableEntity;

public interface Mapper<E extends AbstractObject, D extends AuditableEntity<?>> {

	D toEntity(E dto);
	E toObject(D entity);
	List<E> toObjectList(List<D> entities);
	
}
