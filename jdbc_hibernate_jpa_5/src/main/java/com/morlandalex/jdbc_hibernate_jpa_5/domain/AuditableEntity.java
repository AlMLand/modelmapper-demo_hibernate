package com.morlandalex.jdbc_hibernate_jpa_5.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public abstract class AuditableEntity<T> {

	@CreatedBy
	@Column(name = "created_by")
	protected String createdBy;
	
	@CreatedDate
	@Column(name = "created_date")
	protected LocalDate createdDate;

	@CreationTimestamp
	@Column(name = "created_date_time")
	protected LocalDateTime createdDateTime;
	
	@LastModifiedBy
	@Column(name = "last_modified_by")
	protected String lastModifiedBy;
	
	@LastModifiedDate
	@Column(name = "last_modified_date")
	protected LocalDate lastModifiedDate;

}
