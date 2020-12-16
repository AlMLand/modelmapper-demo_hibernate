package com.morlandalex.jdbc_hibernate_jpa_5.view;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import com.morlandalex.jdbc_hibernate_jpa_5.DBConnection.H2Connection;
import com.morlandalex.jdbc_hibernate_jpa_5.serviceJPARepository.AlbumService;

public class DemoRunFile {

	public static void main(String[] args) {

		GenericApplicationContext context = new AnnotationConfigApplicationContext(H2Connection.class);
		AlbumService service = context.getBean(AlbumService.class, "albumServiceJPA");
		
		service.fetchAll();
		
		context.close();
		
	}

}