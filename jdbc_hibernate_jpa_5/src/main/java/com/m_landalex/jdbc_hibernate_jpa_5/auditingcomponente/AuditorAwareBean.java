package com.m_landalex.jdbc_hibernate_jpa_5.auditingcomponente;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

@Component
public class AuditorAwareBean implements AuditorAware<String>{

	@Override
	public Optional<String> getCurrentAuditor() {
		return Optional.of("IchHabeDasGemacht");
	}
	
}