package com.morlandalex.jdbc_hibernate_jpa_5.serviceCRUDrepository;

import java.time.LocalDate;
import java.util.Collection;

import com.morlandalex.jdbc_hibernate_jpa_5.data.Singer;

public interface SingerService {

	Collection<Singer> fetchByBirthDateLessThanEqual(LocalDate localDate);
	Collection<Singer> fetchByBirthDateGreaterThanEqual(LocalDate localDate);
	Collection<Singer> fetchByFirstNameContainingIgnoreCase(String partFirstName);
	Collection<Singer> fetchByFirstName(String firstName);
	Collection<Singer> fetchByLastName(String lastName);
	Collection<Singer> fetchByFirstNameAndLastName(String firstName, String lastName);
	<S extends Singer> S save(S Singer);
	<S extends Singer> Collection<S> saveAll(Collection<S> singers);
	Singer fetchById(Long id);
	boolean existsById(Long id);
	Iterable<Singer> fetchAll();
	Collection<Singer> fetchAllById(Collection<Long> ids);
	long count();
	void deleteById(Long id);
	void delete(Singer Singer);
	void deleteAll(Collection<? extends Singer> singers);
	void deleteAll();
	
}
