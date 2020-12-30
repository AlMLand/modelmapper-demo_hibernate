package com.morlandalex.jdbc_hibernate_jpa_5.serviceJPARepository;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.envers.AuditReader;
import org.hibernate.envers.AuditReaderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.morlandalex.jdbc_hibernate_jpa_5.Mapper.SingerMapper;
import com.morlandalex.jdbc_hibernate_jpa_5.data.Singer;
import com.morlandalex.jdbc_hibernate_jpa_5.domain.SingerEntity;
import com.morlandalex.jdbc_hibernate_jpa_5.persistenceJPARepository.SingerRepository;

@Service("singerServiceJPA")
public class SingerService {

	@Autowired
	private SingerRepository singerRepository;
	@Autowired
	private SingerMapper singerMapper;
	@PersistenceContext
	private EntityManager entityManager;
	
	@Transactional(readOnly = true)
	public Singer fetchAuditByRevision(Long id, int revision) {
		AuditReader auditReader = AuditReaderFactory.get(entityManager);
		Singer returnedSinger = singerMapper.toObject(auditReader.find(SingerEntity.class, id, revision));
		System.out.println(returnedSinger);
		return returnedSinger;
	}
	
	@Transactional(readOnly = true)
	public List<Singer> fetchAll(){
		List<Singer> returnedSingerList = singerMapper.toObjectList(singerRepository.findAll());
		returnedSingerList.forEach(System.out::println);
		return returnedSingerList;
	}
	
	@Transactional(readOnly = true)
	public List<Singer> fetchByLastName(String lastName){
		List<Singer> returnedList = singerMapper.toObjectList(singerRepository.findByLastNameIgnoreCaseOrderByFirstName(lastName));
		returnedList.forEach(System.out::println);
		return returnedList;
	}

	public Singer save(Singer singer) {
		singerRepository.save(singerMapper.toEntity(singer));
		return singer;
	}
	@Transactional(readOnly = true)
	public Singer fetchById(Long id) {
		Singer returnedSinger = singerMapper.toObject(singerRepository.getOne(id));
		System.out.println(returnedSinger);
		return returnedSinger;
	}
	
	@Transactional(readOnly = true)
	public List<Singer> fetchByBirthDate(LocalDate date){
		List<Singer> returnedSingerList = singerMapper.toObjectList(singerRepository.findByBirthDate(date));
		returnedSingerList.forEach(System.out::println);
		return returnedSingerList;
	}
/*	
	public List<SingerSummary> fetchAllSingerSummary(){
		List<SingerSummary> returnedSingerSummaryList = ObjectMapperUtils.mapAll(singerRepository.findAllSingerSummary(), SingerSummary.class);
		returnedSingerSummaryList.forEach(System.out::println);
		return returnedSingerSummaryList;
	}
	
	public SingerSummary fetchByIdSingerSummary(Long id) {
		SingerSummary returnedSingerSummary = ObjectMapperUtils.map(singerRepository.findByIdSingerSummary(id), SingerSummary.class);
		System.out.println(returnedSingerSummary);
		return returnedSingerSummary;
	}
*/	
}