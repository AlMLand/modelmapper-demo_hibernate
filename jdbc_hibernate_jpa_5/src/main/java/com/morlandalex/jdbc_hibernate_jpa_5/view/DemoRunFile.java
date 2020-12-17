package com.morlandalex.jdbc_hibernate_jpa_5.view;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import com.morlandalex.jdbc_hibernate_jpa_5.DBConnection.PostgeSQLConnection;
import com.morlandalex.jdbc_hibernate_jpa_5.serviceJPARepository.SingerService;

public class DemoRunFile {

	public static void main(String[] args) {

		GenericApplicationContext context = new AnnotationConfigApplicationContext(PostgeSQLConnection.class);
		SingerService service = context.getBean(SingerService.class, "albumServiceJPA");
		
		service.fetchAll();
		
		context.close();
		
	}

}