package com.morlandalex.jdbc_hibernate_jpa_5.serviceCRUDRepository;

import java.time.LocalDate;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.morlandalex.jdbc_hibernate_jpa_5.data.Album;
import com.morlandalex.jdbc_hibernate_jpa_5.data.Instrument;
import com.morlandalex.jdbc_hibernate_jpa_5.data.Singer;
import com.morlandalex.jdbc_hibernate_jpa_5.serviceJPARepository.InstrumentService;
import com.morlandalex.jdbc_hibernate_jpa_5.serviceJPARepository.SingerService;

@Service("dbInitialization")
public class DBInitialization {

	@Autowired
	private SingerService singerService;
	@Autowired
	private InstrumentService instrumentService;
	
	@PostConstruct
	public void dbInitialization() {
		singerService.save(Singer.builder()
				.firstName("Alex")
				.lastName("Morland")
				.birthDate(LocalDate.of(1985, 6, 5))
				.album(Album.builder().title("A_A_A_A").releaseDate(LocalDate.of(2000, 10, 23)).build())
				.instrument(instrumentService.save(Instrument.builder().instrument("Guitar").build()))
				.build());

		singerService.save(Singer.builder()
				.firstName("Elvira")
				.lastName("Morland")
				.birthDate(LocalDate.of(1986, 9, 16))
				.album(Album.builder().title("B_B_B_B").releaseDate(LocalDate.of(1995, 1, 28)).build())
				.instrument(instrumentService.save(Instrument.builder().instrument("Bassguitar").build()))
				.build());
		
		singerService.save(Singer.builder()
				.firstName("Timur")
				.lastName("Morland")
				.birthDate(LocalDate.of(2017, 8, 7))
				.album(Album.builder().title("C_C_C_C").releaseDate(LocalDate.of(2018, 10, 12)).build())
				.album(Album.builder().title("D_D_D_D").releaseDate(LocalDate.of(2019, 7, 11)).build())
				.instrument(instrumentService.save(Instrument.builder().instrument("Voice").build()))
				.instrument(instrumentService.save(Instrument.builder().instrument("Drum").build()))
				.build());
	}
	
}
