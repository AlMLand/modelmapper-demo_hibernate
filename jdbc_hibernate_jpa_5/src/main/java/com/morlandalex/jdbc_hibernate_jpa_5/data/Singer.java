package com.morlandalex.jdbc_hibernate_jpa_5.data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.Singular;
import lombok.ToString;

@Setter
@Getter
@Builder
@ToString(exclude = {"albums","instruments"})
@AllArgsConstructor
@RequiredArgsConstructor
public class Singer {

	private Long id;
	private String firstName;
	private String lastName;
	private LocalDate birthDate;             
	private String createdBy;
	private LocalDate createdDate;
	private LocalDateTime createdDateTime;
	private String lastModifiedBy;
	private LocalDate lastModifiedDate;
	@Singular
	private Set<Album> albums;
	@Singular
	private Set<Instrument> instruments;
	
}
