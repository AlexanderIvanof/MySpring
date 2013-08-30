package com.alex.spring.jdbc.dao.impl;

import javax.sql.DataSource;

import org.springframework.beans.factory.BeanCreationException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.alex.spring.jdbc.dao.ContactDAOXML;

public class JdbcCondactDao implements ContactDAOXML {

	private DataSource dataSource;
	private JdbcTemplate jdbcTemp;
	
	/*
	 * Add a common class for work with JDBC in spring
	 */
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemp = new JdbcTemplate(dataSource);
	}
	
	/*
	 * Use init-method - attribute in context xml 
	 */
	public void afterInitMethod() throws Exception{
		if(dataSource == null){
			throw new BeanCreationException("DataSource must be set");
		}
	}

}
