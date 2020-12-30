package com.morlandalex.jdbc_hibernate_jpa_5.serviceJPARepository;

import java.util.Collection;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration.AccessLevel;
import org.modelmapper.convention.MatchingStrategies;

//@Component("objectMapperUtilsWithModelMapper")
public class ObjectMapperUtils {

	private static ModelMapper modelMapper;

	static {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT).setFieldMatchingEnabled(true)
				.setSkipNullEnabled(true).setFieldAccessLevel(AccessLevel.PRIVATE);
	}

	/**
	 * One Singer entity(from ... .domain.Singer package) to Singer(from ...
	 * .data.Singer package) and reversed.
	 * 
	 * @param <T> source type
	 * @param <D> destination type
	 */
	public static <T, D> D map(final T entity, Class<D> destinationType) {
		return modelMapper.map(entity, destinationType);
	}

	/**
	 * List from Singer entity(from ... .domain.Singer package) to Singer(from ...
	 * .data.Singer package) and reversed.
	 * 
	 * @param <T> source type
	 * @param <D> destination type
	 */
	public static <T, D> Collection<D> mapAll(final Collection<T> entityList, Class<D> destinationType) {
		return entityList.stream().map(entity -> map(entity, destinationType)).collect(Collectors.toList());
	}

}
