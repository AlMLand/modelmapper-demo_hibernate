package com.m_landalex.jdbc_hibernate_jpa_5.data;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@ToString(callSuper = true, exclude = {"singers"})
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Instrument extends AbstractObject{

	private String instrument;
	private List<Singer> singers;

}
