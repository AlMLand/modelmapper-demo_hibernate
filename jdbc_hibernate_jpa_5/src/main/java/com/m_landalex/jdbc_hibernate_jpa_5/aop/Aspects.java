package com.m_landalex.jdbc_hibernate_jpa_5.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Aspect
@Component
public class Aspects {

	@Before("execution(* com.m_landalex.jdbc_hibernate_jpa_5.persistenceJPA.service.*.save(..))")
	public void beforeServiceSave(JoinPoint joinPoint) {
		log.info("Enter: {}.{} () with arguments[s] = {}", joinPoint.getSignature().getDeclaringTypeName(),
				joinPoint.getSignature().getName(), Arrays.toString(joinPoint.getArgs()));
	}
	
	@After("execution(* com.m_landalex.jdbc_hibernate_jpa_5.persistenceJPA.service.*.save(..))")
	public void afterServiceSave(JoinPoint joinPoint) {
		log.info("Enter: {}.{} () with arguments[s] = {}", joinPoint.getSignature().getDeclaringTypeName(),
				joinPoint.getSignature().getName(), Arrays.toString(joinPoint.getArgs()));
	}
	
}
