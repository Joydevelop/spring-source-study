package com.joy;

import com.joy.mybatis.JoyMapperScan;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author Joy
 */
@ComponentScan("com.joy")
//@JoyMapperScan("com.joy.mapper")
//@EnableAspectJAutoProxy
@EnableTransactionManagement
@Configuration
public class AppConfig {

	//	@Bean
//	public SqlSessionFactory sqlSessionFactory() throws IOException {
//		InputStream resourceAsStream = Resources.getResourceAsStream("mybatis.xml");
//		return new SqlSessionFactoryBuilder().build(resourceAsStream);
//	}
	@Bean
	public JdbcTemplate jdbcTemplate() {
		return new JdbcTemplate(dataSource());
	}

	@Bean
	public PlatformTransactionManager transactionManager() {
		DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
		transactionManager.setDataSource(dataSource());
		//部分失败全部回滚
		transactionManager.setGlobalRollbackOnParticipationFailure(false);
		return transactionManager;
	}

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/joy?characterEncoding=utf-8&useSSL=false");
		dataSource.setUsername("root");
		dataSource.setPassword("123456");
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		return dataSource;
	}
}
