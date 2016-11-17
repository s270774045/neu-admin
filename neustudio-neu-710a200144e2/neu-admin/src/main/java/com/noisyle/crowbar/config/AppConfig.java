package com.noisyle.crowbar.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.noisyle.crowbar.core.util.CryptoEnvWrapper;
import com.noisyle.crowbar.core.util.SpringContextHolder;

@Configuration
@PropertySource("classpath:/spring-context.properties")
@EnableAspectJAutoProxy(proxyTargetClass = true)
@EnableTransactionManagement
@ComponentScan(basePackages = { "com.noisyle.crowbar.repository", "com.noisyle.crowbar.service" })
public class AppConfig {

	private CryptoEnvWrapper env;

	@Autowired
	private void setEnv(Environment env) {
		this.env = new CryptoEnvWrapper(env);
	}

	@Bean(destroyMethod = "close")
	public DataSource dataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(env.getProperty("db.driverClassName"));
		dataSource.setUrl(env.getProperty("db.url"));
		dataSource.setUsername(env.getProperty("db.username"));
		dataSource.setPassword(env.getProperty("db.password"));
		dataSource.setInitialSize(env.getProperty("db.initialSize", Integer.class));
		dataSource.setMaxTotal(env.getProperty("db.maxTotal", Integer.class));
		dataSource.setMinIdle(env.getProperty("db.minIdle", Integer.class));
		dataSource.setMaxIdle(env.getProperty("db.maxIdle", Integer.class));
		return dataSource;
	}

	@Bean
	@Autowired
	@DependsOn({ "dataSource" })
	public LocalSessionFactoryBean sessionFactory(DataSource dataSource) {
		LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
		sessionFactoryBean.setDataSource(dataSource);
		sessionFactoryBean.setPackagesToScan("com.noisyle.crowbar.model");
		Properties p = new Properties();
		p.setProperty("hibernate.dialect", env.getProperty("hibernate.dialect"));
		p.setProperty("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
		p.setProperty("hibernate.format_sql", env.getProperty("hibernate.format_sql"));
		sessionFactoryBean.setHibernateProperties(p);
		return sessionFactoryBean;
	}

	@Bean
	@Autowired
	@DependsOn({ "sessionFactory" })
	public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager txManager = new HibernateTransactionManager(sessionFactory);
		return txManager;
	}

	@Bean
	public SpringContextHolder springContextHolder() {
		return new SpringContextHolder();
	}
}
