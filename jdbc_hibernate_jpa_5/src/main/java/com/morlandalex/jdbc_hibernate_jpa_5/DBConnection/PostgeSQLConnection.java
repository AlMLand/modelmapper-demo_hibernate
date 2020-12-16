package com.morlandalex.jdbc_hibernate_jpa_5.DBConnection;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@ComponentScan(basePackages = "com.morlandalex.jdbc_hibernate_jpa_5")
@PropertySource("classpath:appConfig.properties")
@EnableTransactionManagement
@EnableJpaRepositories("com.morlandalex.jdbc_hibernate_jpa_5.persistenceJPARepository")
@EnableJpaAuditing(auditorAwareRef = "auditorAwareBean")
@Configuration
public class PostgeSQLConnection {

	@Autowired
	private Environment environment;
	
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		try {
			dataSource.setDriverClassName(environment.getRequiredProperty("jdbc.driverClassName"));
			dataSource.setUrl(environment.getRequiredProperty("jdbc.url"));
			dataSource.setUsername(environment.getRequiredProperty("jdbc.username"));
			dataSource.setPassword(environment.getRequiredProperty("jdbc.password"));
			return dataSource;
		}catch (Exception e) {
			System.out.println("DataSource bean cannot to created " + e);
			return null;
		}
	}
	
	private Properties getProperties() {
		Properties properties = new Properties();
		properties.setProperty("posgresql.hibernate.dialect", environment.getRequiredProperty("posgresql.hibernate.dialect"));
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
		factoryBean.setPackagesToScan("com.morlandalex.jdbc_hibernate_jpa_5.domain");
		factoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		factoryBean.setJpaProperties(getProperties());
		factoryBean.afterPropertiesSet();
		return factoryBean.getNativeEntityManagerFactory();
	}
	
	@Bean
	public PlatformTransactionManager transactionManager() {
		return new JpaTransactionManager(entityManagerFactory());
	}
	
}
