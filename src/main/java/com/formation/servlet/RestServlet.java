package com.formation.servlet;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.formation.service.config.ServiceConfig;

public class RestServlet extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		// retourner le tableau des classes de configuration Spring (pour nous
		// ça sera uniquement ServiceConfig)

		return new Class<?>[] { ServiceConfig.class };
	}

	@Override
	protected String[] getServletMappings() {
		// retourner le mapping URL associé à cette Servlet. /service/*
		// par exemple
		return new String[] { "/service/*" };
	}

}
