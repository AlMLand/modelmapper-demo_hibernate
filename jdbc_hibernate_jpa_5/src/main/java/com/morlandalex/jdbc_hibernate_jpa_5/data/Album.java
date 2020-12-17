package com.morlandalex.jdbc_hibernate_jpa_5.data;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@Builder
@ToString
@AllArgsConstructor
@RequiredArgsConstructor
public class Album {
	
	private Long id;
	private String title;
	private LocalDate releaseDate;
	private Singer singer;
	private String createdBy;
	private LocalDate createdDate;
	private LocalDateTime createdDateTime;
	private String lastModifiedBy;
	private LocalDate lastModifiedDate;

}
