package com.morlandalex.jdbc_hibernate_jpa_5.serviceCRUDrepository;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.morlandalex.jdbc_hibernate_jpa_5.data.Instrument;
import com.morlandalex.jdbc_hibernate_jpa_5.domain.InstrumentEntity;
import com.morlandalex.jdbc_hibernate_jpa_5.persistenceCRUDrepository.InstrumentRepository;
import com.morlandalex.jdbc_hibernate_jpa_5.staticmapper.ObjectMapperUtils;

@Service("instrumentService")
public class InstrumentServiceImpl implements InstrumentService {

	@Autowired(required = false)
	private InstrumentRepository instrumentRepository;
	
	@Override
	public Collection<Instrument> fetchByInstrumentContainingIgnoreCase(String partInstrumentName) {
		Collection<Instrument> returnedInstrumentList = ObjectMapperUtils
				.mapAll(instrumentRepository.findByInstrumentContainingIgnoreCase(partInstrumentName), Instrument.class);
		returnedInstrumentList.forEach(System.out::println);
		return returnedInstrumentList;
	}
	
	@Override
	public <I extends Instrument> I save(I instrument) {
		instrumentRepository.save(ObjectMapperUtils.map(instrument, InstrumentEntity.class));
		return instrument;
	}

	@Override
	public <I extends Instrument> Collection<I> saveAll(Collection<I> instruments) {
		instrumentRepository.saveAll(ObjectMapperUtils.mapAll(instruments, InstrumentEntity.class));
		return instruments;
	}

	@Override
	public Instrument fetchById(Long id) {
		Instrument returnedInstrument = ObjectMapperUtils.map(instrumentRepository.findById(id), Instrument.class);
		System.out.println(returnedInstrument);
		return returnedInstrument;
	}

	@Override
	public boolean existsById(Long id) {
		return instrumentRepository.existsById(id);
	}

	@Override
	public Collection<Instrument> fetchAll() {
		Collection<Instrument> returnedInstrumentList = ObjectMapperUtils.mapAll(instrumentRepository.findAll(), Instrument.class);
		returnedInstrumentList.forEach(System.out::println);
		return returnedInstrumentList;
	}

	@Override
	public Collection<Instrument> fetchAllById(Collection<Long> ids) {
		Collection<Instrument> returnedInstrumentList = ObjectMapperUtils.mapAll(instrumentRepository.findAllById(ids), Instrument.class);
		returnedInstrumentList.forEach(System.out::println);
		return returnedInstrumentList;
	}

	@Override
	public long count() {
		return instrumentRepository.count();
	}

	@Override
	public void deleteById(Long id) {
		instrumentRepository.deleteById(id);
	}

	@Override
	public void delete(Instrument instrument) {
		instrumentRepository.delete(ObjectMapperUtils.map(instrument, InstrumentEntity.class));
	}

	@Override
	public void deleteAll(Collection<? extends Instrument> instruments) {
		instrumentRepository.deleteAll(ObjectMapperUtils.mapAll(instruments, InstrumentEntity.class));
	}

	@Override
	public void deleteAll() {
		instrumentRepository.deleteAll();
	}

}