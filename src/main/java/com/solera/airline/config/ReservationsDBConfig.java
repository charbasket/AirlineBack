package com.solera.airline.config;



import java.util.HashMap;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import jakarta.persistence.EntityManagerFactory;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "resEntityManagerFactory", transactionManagerRef = "resTransactionManager", basePackages = {
		"com.solera.airline.model.reservation.repository" })
public class ReservationsDBConfig {

	@Bean(name = "resDataSource")
	@ConfigurationProperties(prefix = "spring.reservation.datasource")
	public DataSource dataSource() {
		return DataSourceBuilder.create().build();
	}

	@Bean(name = "resEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean resEntityManagerFactory(EntityManagerFactoryBuilder builder,
			@Qualifier("resDataSource") DataSource dataSource) {
		HashMap<String, Object> properties = new HashMap<>();
		properties.put("hibernate.hbm2ddl.auto", "update");
		properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		return builder.dataSource(dataSource).properties(properties)
				.packages("com.solera.airline.model.reservation.entity").persistenceUnit("Reservation").build();
	}

	@Bean(name = "resTransactionManager")
	public PlatformTransactionManager resTransactionManager(
			@Qualifier("resEntityManagerFactory") EntityManagerFactory resEntityManagerFactory) {
		return new JpaTransactionManager(resEntityManagerFactory);
	}
}
