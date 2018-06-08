package com.collaboration.hibernateconfig;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan("com.collaboration")
@EnableTransactionManagement
public class HibernateConfig {
	@Bean(name = "dataSource")
	public DataSource getDataSource() {

		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
		// jdbc:h2:tcp://localhost/~/shopping
		dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		// org.h2.Driver
		dataSource.setUsername("COLLABORATIONDB");
		dataSource.setPassword("JIvan8181#");
		return dataSource;

	}

	@Bean(name = "properties")
	public Properties getHibernateProperties() {
		Properties properties = new Properties();
	
		properties.put("hibernate.show_sql", "true");

		return properties;

	}

	@Autowired
	@Bean(name = "sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource) {
		LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
		sessionBuilder.addProperties(getHibernateProperties());
		sessionBuilder.scanPackages("com.collaboration");

		return sessionBuilder.buildSessionFactory();

	}

	@Bean(name = "transactionManager")
	public HibernateTransactionManager geTransactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
		return transactionManager;
	}

}
