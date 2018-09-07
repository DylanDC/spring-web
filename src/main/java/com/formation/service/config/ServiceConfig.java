package com.formation.service.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.formation.config.AppConfig;
import com.formation.servlet.service.controller.AdminRestController;

@Configuration
@EnableWebMvc
@ComponentScan(basePackageClasses = { AdminRestController.class })
@Import(AppConfig.class)

public class ServiceConfig implements WebMvcConfigurer {
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {

		registry.enableContentNegotiation(new MappingJackson2JsonView());

	}

}
