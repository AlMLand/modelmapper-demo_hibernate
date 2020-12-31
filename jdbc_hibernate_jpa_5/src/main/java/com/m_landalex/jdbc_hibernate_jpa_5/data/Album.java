package com.m_landalex.jdbc_hibernate_jpa_5.data;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Album extends AbstractObject{
	
	private String title;
	private LocalDate releaseDate;
	private Singer singerId;

}
