package com.formation;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.formation.servlet.HelloController;

@Configuration
@EnableWebMvc
@ComponentScan(basePackageClasses = { HelloController.class }) // MessageServiceImpl.class,
																// ChatConsole.class,MessageDao.class
public class AppConfig implements WebMvcConfigurer {
	// @Bean
	// public PlatformTransactionManager transactionManager(EntityManagerFactory
	// emf) {
	// JpaTransactionManager txManager = new JpaTransactionManager();
	// txManager.setEntityManagerFactory(emf);
	// return txManager;
	// }
	//
	// @Bean
	// public EntityManagerFactory entityManagerFactory(DataSource dataSource) {
	// HibernateJpaVendorAdapter vendorAdapter = new
	// HibernateJpaVendorAdapter();
	// vendorAdapter.setGenerateDdl(true);
	// vendorAdapter.setShowSql(true);
	// LocalContainerEntityManagerFactoryBean factory = new
	// LocalContainerEntityManagerFactoryBean();
	// factory.setJpaVendorAdapter(vendorAdapter);
	// factory.setPackagesToScan("com.formation.dao", "com.formation.entity");
	// factory.setDataSource(dataSource);
	// factory.afterPropertiesSet();
	// return factory.getObject();
	// }

}