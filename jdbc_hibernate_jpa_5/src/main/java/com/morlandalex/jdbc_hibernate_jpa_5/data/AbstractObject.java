package com.morlandalex.jdbc_hibernate_jpa_5.data;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.Data;

@Data
public abstract class AbstractObject {

	protected Long id;
	protected String createdBy;
	protected LocalDate createdDate;
	protected LocalDateTime createdDateTime;
	protected String lastModifiedBy;
	protected LocalDate lastModifiedDate;
	
}
