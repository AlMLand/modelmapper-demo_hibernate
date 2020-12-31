package com.m_landalex.jdbc_hibernate_jpa_5.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.m_landalex.jdbc_hibernate_jpa_5.data.AbstractObject;
import com.m_landalex.jdbc_hibernate_jpa_5.domain.AuditableEntity;

public abstract class AbstractMapper<E extends AbstractObject, D extends AuditableEntity<?>> implements Mapper<E, D> {

	@Autowired
	private ModelMapper modelMapper;
	private Class<E> dtoClass;
	private Class<D> entityClass;
	
	public AbstractMapper(Class<E> dtoClass, Class<D> entityClass) {
		super();
		this.dtoClass = dtoClass;
		this.entityClass = entityClass;
	}

	@Override
	public D toEntity(E dto) {
		return Objects.isNull(dto) ? null : modelMapper.map(dto, entityClass);
	}

	@Override
	public E toObject(D entity) {
		return Objects.isNull(entity) ? null : modelMapper.map(entity, dtoClass);
	}
	
	@Override
	public List<E> toObjectList(List<D> entities){
		return Objects.isNull(entities) ? new ArrayList<E>() : entities.stream()
				.map(entity -> modelMapper.map(entity, dtoClass))
				.collect(Collectors.toList());
	}
	
	Converter<E, D> toEntityConverter(){
		return context -> {
			E source = context.getSource();
			D destination = context.getDestination();
			mapSpecificFields(source, destination);
			return context.getDestination();
		};
	}
	
	Converter<D, E> toObjectConverter(){
		return context -> {
			D source = context.getSource();
			E destination = context.getDestination();
			mapSpecificFields(source, destination);
			return context.getDestination();
		};
	}
	
	void mapSpecificFields(E source, D destination) {}

	void mapSpecificFields(D source, E destination) {}
	
}
