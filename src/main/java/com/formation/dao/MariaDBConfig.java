package com.formation.dao;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class MariaDBConfig {

	@Bean
	public DataSource dataSource() {

		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("java.sql.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/user_interaction");
		dataSource.setUsername("root");
		dataSource.setPassword("");

		return dataSource;
	}
}