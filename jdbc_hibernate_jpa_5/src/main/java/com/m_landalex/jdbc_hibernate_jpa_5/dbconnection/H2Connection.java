package com.m_landalex.jdbc_hibernate_jpa_5.dbconnection;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration.AccessLevel;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableAspectJAutoProxy
@PropertySource("classpath:appConfig.properties")
@Configuration
@ComponentScan(basePackages = "com.m_landalex.jdbc_hibernate_jpa_5")
@EnableJpaRepositories(basePackages = "com.m_landalex.jdbc_hibernate_jpa_5.persistenceJPA.repository")
@EnableTransactionManagement
@EnableJpaAuditing(auditorAwareRef = "auditorAwareBean")
public class H2Connection {

	@Autowired
	private Environment environment;
	
	@Bean
	public ModelMapper modelMapper() {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration()
		.setMatchingStrategy(MatchingStrategies.STRICT)
		.setFieldMatchingEnabled(true)
		.setSkipNullEnabled(true)
		.setFieldAccessLevel(AccessLevel.PRIVATE);
		return modelMapper;
	}
	
	@Bean
	public DataSource dataSource() {
		try {
			return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2).build();
		}catch(Exception exception) {
			System.out.println("DataSource bean cannot to created " + exception.getStackTrace());
			return null;
		}
	}
	
	private Properties getProperties() {
		Properties properties = new Properties();
		properties.setProperty("h2.hibernate.dialect", environment.getRequiredProperty("h2.hibernate.dialect"));
		properties.setProperty("hibernate.show_sql", environment.getRequiredProperty("hibernate.show_sql"));
		properties.setProperty("hibernate.format_sql", environment.getRequiredProperty("hibernate.format_sql"));
		properties.setProperty("hibernate.use_sql_comments", environment.getRequiredProperty("hibernate.use_sql_comments"));
		properties.setProperty("hibernate.max_fetch_depth", environment.getRequiredProperty("hibernate.max_fetch_depth"));
		properties.setProperty("hibernate.jdbc.batch_size", environment.getRequiredProperty("hibernate.jdbc.batch_size"));
		properties.setProperty("hibernate.jdbc.fetch_size", environment.getRequiredProperty("hibernate.jdbc.fetch_size"));
		properties.setProperty("hibernate.hbm2ddl.auto", environment.getRequiredProperty("hibernate.hbm2ddl.auto"));
		properties.setProperty("org.hibernate.envers.audit_table_suffix", environment.getRequiredProperty("org.hibernate.envers.audit_table_suffix"));
		properties.setProperty("org.hibernate.envers.revision_field_name", environment.getRequiredProperty("org.hibernate.envers.revision_field_name"));
		properties.setProperty("org.hibernate.envers.revision_type_field_name", environment.getRequiredProperty("org.hibernate.envers.revision_type_field_name"));
		properties.setProperty("org.hibernate.envers.audit_strategy", environment.getRequiredProperty("org.hibernate.envers.audit_strategy"));
		properties.setProperty("org.hibernate.envers.audit_strategy_validity_end_rev_field_name", environment
				.getRequiredProperty("org.hibernate.envers.audit_strategy_validity_end_rev_field_name"));
		properties.setProperty("org.hibernate.envers.audit_strategy_validity_store_revend_timestamp", environment
				.getRequiredProperty("org.hibernate.envers.audit_strategy_validity_store_revend_timestamp"));
		properties.setProperty("org.hibernate.envers.audit_strategy_validity_store_revend_timestamp_field_name", environment
				.getRequiredProperty("org.hibernate.envers.audit_strategy_validity_revend_timestamp_field_name"));
		return properties;
	}
	
	@Bean
	public EntityManagerFactory entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
		factoryBean.setDataSource(dataSource());
		factoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		factoryBean.setPackagesToScan("com.m_landalex.jdbc_hibernate_jpa_5.domain");
		factoryBean.setJpaProperties(getProperties());
		factoryBean.afterPropertiesSet();
		return factoryBean.getNativeEntityManagerFactory();
	}
	
	@Bean
	public PlatformTransactionManager transactionManager() {
		return new JpaTransactionManager(entityManagerFactory());
	}
	
}
