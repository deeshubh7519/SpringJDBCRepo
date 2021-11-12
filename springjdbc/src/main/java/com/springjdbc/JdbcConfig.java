package com.springjdbc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.springjdbc.dao.StudentDao;
import com.springjdbc.dao.StudentDaoImpl;

@Configuration
@ComponentScan(basePackages = "com.springjdbc.dao")
public class JdbcConfig {

	@Bean(name = { "ds" })
	public DriverManagerDataSource getDataSource()
	// Here We can use 'DataSource' class instead of 'DriverManagerDataSource'
	{
		DriverManagerDataSource dSource = new DriverManagerDataSource();
		dSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dSource.setUrl("jdbc:mysql://localhost:3306/springjdbc");
		dSource.setUsername("root");
		dSource.setPassword("pass@123");

		return dSource;
	}

	@Bean(name = { "jdbcTemplate" })
	public JdbcTemplate getJdbcTemplate() {

		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(getDataSource());

		return jdbcTemplate;
	}

	/*
	 * // When we use @component annotation dont use this class because @autowired
	 * // annotation use implicitly
	 * 
	 * @Bean(name = { "studentDao" }) public StudentDao getStudentDao() {
	 * 
	 * StudentDaoImpl studentDao = new StudentDaoImpl();
	 * studentDao.setJdbcTemplate(getJdbcTemplate());
	 * 
	 * return studentDao; }
	 */
}
