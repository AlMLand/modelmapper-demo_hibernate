package com.m_landalex.jdbc_hibernate_jpa_5.data;

import java.time.LocalDate;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Singular;
import lombok.ToString;

@Data
@ToString(callSuper = true, exclude = {"albums","instruments"})
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Singer extends AbstractObject{

	private String firstName;
	private String lastName;
	private LocalDate birthDate;
	@Singular
	private List<Album> albums;
	@Singular
	private List<Instrument> instruments;
	
}
