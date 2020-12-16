package com.morlandalex.jdbc_hibernate_jpa_5.serviceJPARepository;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ObjectMapperUtils {

	private static ModelMapper modelMapper = new ModelMapper();
	
	static {
		modelMapper = new ModelMapper();
		modelMapper.getConfiguration()
		.setMatchingStrategy(MatchingStrategies.STRICT)
		.setSkipNullEnabled(true)
		.setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE);
	}
	
	/*
	 * One Singer entity(from ... .domain.Singer package) to Singer(from ... .data.Singer package)
	 * and reversed
	 */
	public static <T,D> D map(final T entity, Class<D> destinationType) {
		return modelMapper.map(entity, destinationType);
	}
	
	/*
	 * List from Singer entity(from ... .domain.Singer package) to Singer(from ... .data.Singer package)
	 * and reversed
	 */
	public static <T,D> List<D> mapAll(final Collection<T> entityList, Class<D> destinationType){
		return entityList.stream()
				.map(entity -> map(entity, destinationType))
				.collect(Collectors.toList());
	}
	
}
