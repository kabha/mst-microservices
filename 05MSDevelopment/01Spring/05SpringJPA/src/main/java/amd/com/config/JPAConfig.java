package amd.com.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages="amd.com")
@EnableTransactionManagement
@PropertySource("classpath:persistence-mySql.properties")
public class JPAConfig {
	

	@Autowired
	private Environment env;
	
	
	@Bean
	public DataSource getDataSource() {
	  DriverManagerDataSource dataSource = new DriverManagerDataSource();
	  dataSource.setDriverClassName(env.getRequiredProperty("jdbc.driverClassName"));
	  dataSource.setUrl(env.getRequiredProperty("jdbc.url"));
	  dataSource.setUsername(env.getRequiredProperty("jdbc.username"));
	  dataSource.setPassword(env.getRequiredProperty("jdbc.password"));
	  return dataSource;
	}
	
	
	
	@Bean
	public LocalContainerEntityManagerFactoryBean   entityManagerFactory() {
	 LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new  LocalContainerEntityManagerFactoryBean();
	 DataSource dataSource =getDataSource();
	 
	 
	 entityManagerFactoryBean.setDataSource(dataSource);
	 entityManagerFactoryBean.setPackagesToScan( "amd.com");
	 entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter() );
	 Properties properties = new Properties();
	 properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
	 properties.setProperty("hibernate.hbm2ddl.auto" , "update");
	 entityManagerFactoryBean.setJpaProperties( properties );

	 return entityManagerFactoryBean;
	}


	
	
	@Bean
	  public JpaTransactionManager transactionManager() {
	   JpaTransactionManager transactionManager = new JpaTransactionManager();
	   transactionManager.setEntityManagerFactory(entityManagerFactory().getObject()); 
		   return transactionManager;
	  }


}
