package com.m_landalex.jdbc_hibernate_jpa_5.databaseinitialization;

import java.time.LocalDate;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.m_landalex.jdbc_hibernate_jpa_5.data.Album;
import com.m_landalex.jdbc_hibernate_jpa_5.data.Instrument;
import com.m_landalex.jdbc_hibernate_jpa_5.data.Singer;
import com.m_landalex.jdbc_hibernate_jpa_5.persistenceJPA.service.SingerService;

@Service("dbInitialization")
public class DBInitialization {

	@Autowired
	private SingerService singerService;
	
	@PostConstruct
	public void dbInitialization() {
		singerService.save(Singer.builder()
				.firstName("Khabib")
				.lastName("Nurmagomedov")
				.birthDate(LocalDate.of(1988, 9, 20))
				.album(Album.builder().title("A_A_A_A").releaseDate(LocalDate.of(2000, 10, 23)).build())
				.instrument(Instrument.builder().instrument("Guitar").build())
				.build());

		singerService.save(Singer.builder()
				.firstName("Conor")
				.lastName("McGregor")
				.birthDate(LocalDate.of(1988, 7, 14))
				.album(Album.builder().title("B_B_B_B").releaseDate(LocalDate.of(1995, 1, 28)).build())
				.instrument(Instrument.builder().instrument("Bassguitar").build())
				.build());
		
		singerService.save(Singer.builder()
				.firstName("Dustin")
				.lastName("Poirier")
				.birthDate(LocalDate.of(1989, 1, 19))
				.album(Album.builder().title("C_C_C_C").releaseDate(LocalDate.of(2018, 10, 12)).build())
				.album(Album.builder().title("D_D_D_D").releaseDate(LocalDate.of(2019, 7, 11)).build())
				.instrument(Instrument.builder().instrument("Voice").build())
				.instrument(Instrument.builder().instrument("Drum").build())
				.build());
	}
	
}