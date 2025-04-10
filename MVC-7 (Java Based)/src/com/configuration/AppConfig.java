package com.configuration;

import java.util.Properties;

import org.hibernate.cfg.Environment;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(value = "com")
public class AppConfig {

	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver irw = new InternalResourceViewResolver();
		irw.setSuffix(".jsp");

		return irw;
	}

	@Bean
	public DriverManagerDataSource dataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/b53mvc");
		ds.setUsername("root");
		ds.setPassword("root");
		return ds;
	}

	@Bean
	public LocalSessionFactoryBean getSessionFactory() {
		LocalSessionFactoryBean lf = new LocalSessionFactoryBean();

		lf.setDataSource(dataSource());

		Properties prop = new Properties();

		prop.setProperty(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");
		prop.setProperty(Environment.HBM2DDL_AUTO, "update");
		prop.setProperty(Environment.SHOW_SQL, "true");

		lf.setHibernateProperties(prop);

//		lf.setAnnotatedClasses();

		return lf;

	}

}
