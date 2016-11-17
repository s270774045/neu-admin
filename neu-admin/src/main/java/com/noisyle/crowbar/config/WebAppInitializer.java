package com.noisyle.crowbar.config;

import javax.servlet.Filter;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration;

import org.springframework.orm.hibernate4.support.OpenSessionInViewFilter;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.noisyle.crowbar.core.xss.XssFilter;

public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] { AppConfig.class, ShiroConfig.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] { WebConfig.class };
	}

	@Override
	protected void customizeRegistration(ServletRegistration.Dynamic registration) {
		String tmpdir = System.getProperty("java.io.tmpdir");
		MultipartConfigElement multipartConfig = new MultipartConfigElement(tmpdir, 25 * 1024 * 1024,
				125 * 1024 * 1024, 1 * 1024 * 1024);
		registration.setMultipartConfig(multipartConfig);
	}

	@Override
	protected Filter[] getServletFilters() {
		return new Filter[] { openSessionInViewFilter(), shiroFilter(), xssFilter(), characterEncodingFilter(), hiddenHttpMethodFilter() };
	}
	
	private Filter openSessionInViewFilter() {
		OpenSessionInViewFilter filter = new OpenSessionInViewFilter();
		return filter;
	}

	private Filter shiroFilter() {
		DelegatingFilterProxy filter = new DelegatingFilterProxy("shiroFilter");
		filter.setTargetFilterLifecycle(true);
		return filter;
	}

	private XssFilter xssFilter() {
		return new XssFilter();
	}

	private Filter characterEncodingFilter() {
		CharacterEncodingFilter filter = new CharacterEncodingFilter();
		filter.setEncoding("UTF-8");
		filter.setForceEncoding(true);
		return filter;
	}

	private Filter hiddenHttpMethodFilter() {
		return new HiddenHttpMethodFilter();
	}

}
