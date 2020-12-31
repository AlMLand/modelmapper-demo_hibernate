package com.morlandalex.jdbc_hibernate_jpa_5.serviceCRUDrepository;

import java.time.LocalDate;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.morlandalex.jdbc_hibernate_jpa_5.data.Singer;
import com.morlandalex.jdbc_hibernate_jpa_5.domain.SingerEntity;
import com.morlandalex.jdbc_hibernate_jpa_5.persistenceCRUDrepository.SingerRepository;
import com.morlandalex.jdbc_hibernate_jpa_5.staticmapper.ObjectMapperUtils;

@Service("singerService")
public class SingerServiceImpl implements SingerService {

	@Autowired(required = false)
	private SingerRepository singerRepository;
	
	@Override
	public Collection<Singer> fetchByBirthDateLessThanEqual(LocalDate localDate) {
		Collection<Singer> returnedIterableSinger = ObjectMapperUtils.mapAll(singerRepository.findByBirthDateLessThanEqual(localDate), Singer.class);
		returnedIterableSinger.forEach(System.out::println);
		return returnedIterableSinger;
	}
	
	@Override
	public Collection<Singer> fetchByBirthDateGreaterThanEqual(LocalDate localDate) {
		Collection<Singer> returnedIterableSinger = ObjectMapperUtils.mapAll(singerRepository.findByBirthDateGreaterThanEqual(localDate), Singer.class);
		returnedIterableSinger.forEach(System.out::println);
		return returnedIterableSinger;
	}
	
	@Override
	public Collection<Singer> fetchByFirstNameContainingIgnoreCase(String partFirstName) {
		Collection<Singer> returnedIterableSinger = ObjectMapperUtils.mapAll(singerRepository.findByFirstNameContainingIgnoreCase(partFirstName), Singer.class);
		returnedIterableSinger.forEach(System.out::println);
		return returnedIterableSinger;
	}
	
	@Override
	public Collection<Singer> fetchByFirstName(String firstName) {
		Collection<Singer> returnedIterableSinger = ObjectMapperUtils.mapAll(singerRepository.findByFirstName(firstName), Singer.class);
		returnedIterableSinger.forEach(System.out::println);
		return returnedIterableSinger;
	}

	@Override
	public Collection<Singer> fetchByLastName(String lastName) {
		Collection<Singer> returnedIterableSinger = ObjectMapperUtils.mapAll(singerRepository.findByLastName(lastName), Singer.class);
		returnedIterableSinger.forEach(System.out::println);
		return returnedIterableSinger;
	}

	@Override
	public Collection<Singer> fetchByFirstNameAndLastName(String firstName, String lastName) {
		Collection<Singer> returnedIterableSinger = ObjectMapperUtils.mapAll(singerRepository.findByFirstNameAndLastName(firstName, lastName), Singer.class);
		returnedIterableSinger.forEach(System.out::println);
		return returnedIterableSinger;
	}

	@Override
	public <S extends Singer> S save(S singer) {
		singerRepository.save(ObjectMapperUtils.map(singer, SingerEntity.class));
		return singer;
	}

	@Override
	public <S extends Singer> Collection<S> saveAll(Collection<S> singers) {
		singerRepository.saveAll(ObjectMapperUtils.mapAll(singers, SingerEntity.class));
		return singers;
	}

	@Override
	public Singer fetchById(Long id) {
		Singer returnedSinger = ObjectMapperUtils.map(singerRepository.findById(id), Singer.class);
		System.out.println(returnedSinger);
		return returnedSinger;
	}

	@Override
	public boolean existsById(Long id) {
		return singerRepository.existsById(id);
	}

	@Override
	public Collection<Singer> fetchAll() {
		Collection<Singer> returnedIterableSinger = ObjectMapperUtils.mapAll(singerRepository.findAll(), Singer.class);
		returnedIterableSinger.forEach(System.out::println);
		return returnedIterableSinger;
	}

	@Override
	public Collection<Singer> fetchAllById(Collection<Long> ids) {
		Collection<Singer> returnedIterableSinger = ObjectMapperUtils.mapAll(singerRepository.findAllById(ids), Singer.class);
		return returnedIterableSinger;
	}

	@Override
	public long count() {
		return singerRepository.count();
	}

	@Override
	public void deleteById(Long id) {
		singerRepository.deleteById(id);
	}

	@Override
	public void delete(Singer singer) {
		singerRepository.delete(ObjectMapperUtils.map(singer, SingerEntity.class));
	}

	@Override
	public void deleteAll(Collection<? extends Singer> singers) {
		singerRepository.deleteAll(ObjectMapperUtils.mapAll(singers, SingerEntity.class));
	}

	@Override
	public void deleteAll() {
		singerRepository.deleteAll();
	}

}