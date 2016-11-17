package com.noisyle.crowbar.config;

import java.util.List;
import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.noisyle.crowbar.core.hibernate.HibernateAwareObjectMapper;
import com.noisyle.crowbar.core.util.CookieUtils;
import com.noisyle.crowbar.interceptor.WebExceptionResolver;
import com.noisyle.crowbar.interceptor.WebHandlerInterceptor;

@Configuration
@ComponentScan(basePackages = "com.noisyle.crowbar.controller")
public class WebConfig extends WebMvcConfigurationSupport {

	@Bean
	public HandlerMapping resourceHandlerMapping() {
		return super.resourceHandlerMapping();
	}

	@Bean
	public RequestMappingHandlerMapping requestMappingHandlerMapping() {
		return super.requestMappingHandlerMapping();
	}

	@Override
	protected void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/static/**").addResourceLocations("/static/");
		registry.addResourceHandler("/favicon.ico").addResourceLocations("/static/site/img/favicon.ico");
	}

	@Override
	protected void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(localeChangeInterceptor());
		registry.addInterceptor(webHandlerInterceptor());
	}

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		converters.add(Jackson2Converter());
		super.addDefaultHttpMessageConverters(converters);
	}

	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}

	@Bean
	public MessageSource messageSource() {
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasenames("i18n/message");
		messageSource.setUseCodeAsDefaultMessage(true);
		return messageSource;
	}

	@Bean
	public CookieLocaleResolver localeResolver() {
		CookieLocaleResolver localeResolver = new CookieLocaleResolver();
		localeResolver.setCookieMaxAge(CookieUtils.CURRENT_SESSION);
		localeResolver.setCookieName("locale");
		localeResolver.setDefaultLocale(Locale.SIMPLIFIED_CHINESE);
		return localeResolver;
	}

	@Bean
	public LocaleChangeInterceptor localeChangeInterceptor() {
		LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
		localeChangeInterceptor.setParamName("lang");
		return localeChangeInterceptor;
	}

	@Bean
	public WebHandlerInterceptor webHandlerInterceptor() {
		return new WebHandlerInterceptor();
	}

	@Bean
	public StandardServletMultipartResolver multipartResolver() {
		return new StandardServletMultipartResolver();
	}

	@Bean
	public WebExceptionResolver webExceptionResolver() {
		return new WebExceptionResolver();
	}

	@Bean
	@DependsOn({ "Jackson2Mapper" })
	public MappingJackson2HttpMessageConverter Jackson2Converter() {
		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
		converter.setObjectMapper(Jackson2Mapper());
		return converter;
	}

	@Bean
	public HibernateAwareObjectMapper Jackson2Mapper() {
		return new HibernateAwareObjectMapper();
	}

	@Override
	protected void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/error/404").setViewName("error/404");
		registry.addViewController("/error/500").setViewName("error/500");
	}

}
