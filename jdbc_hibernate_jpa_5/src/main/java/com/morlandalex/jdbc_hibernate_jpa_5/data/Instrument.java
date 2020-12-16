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

@Getter
@Setter
@Builder
@ToString(exclude = {"singers"})
@AllArgsConstructor
@RequiredArgsConstructor
public class Instrument {

	private Long id;
	private String instrument;
	private String createdBy;
	private LocalDate createdDate;
	private LocalDateTime createdDateTime;
	private String lastModifiedBy;
	private LocalDate lastModifiedDate;
	@Singular
	private Set<Singer> singers;

}
