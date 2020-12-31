package com.morlandalex.jdbc_hibernate_jpa_5.view;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import com.morlandalex.jdbc_hibernate_jpa_5.dbconnection.H2Connection;
import com.morlandalex.jdbc_hibernate_jpa_5.serviceJPArepository.SingerService;

public class DemoRunFile {

	public static void main(String[] args) {

		GenericApplicationContext context = new AnnotationConfigApplicationContext(H2Connection.class);
		SingerService service = context.getBean(SingerService.class, "albumServiceJPA");
		
		service.fetchByLastName("McGregor");
		
		context.close();
		
	}

}