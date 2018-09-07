package com.formation.servlet;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;

import com.formation.web.config.WebConfig;

public class WebServlet implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		// Load Spring web application configuration
		AnnotationConfigWebApplicationContext webContext = new AnnotationConfigWebApplicationContext();
		webContext.register(WebConfig.class);
		servletContext.addListener(new ContextLoaderListener(webContext));
		// Create and register the DispatcherServlet
		DispatcherServlet servlet = new DispatcherServlet(webContext);
		ServletRegistration.Dynamic registration = servletContext.addServlet("humancontact", servlet);

		registration.setLoadOnStartup(1);
		registration.addMapping("/humancontact/*");
		FilterRegistration.Dynamic encodingFilter = servletContext.addFilter("utf8­encoding",
				new CharacterEncodingFilter());

		encodingFilter.setInitParameter("encoding", "UTF-8");

		encodingFilter.setInitParameter("forceEncoding", "true");

		encodingFilter.addMappingForUrlPatterns(null, false, "/*");

	}

}
