package com.alex.spring.jdbc.annotation;

import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import com.alex.spring.jdbc.Contact;
import com.alex.spring.jdbc.dao.ContactDAO;

@Repository("contactDAO")// like @Component
public class AnnoJdbcContactDAO implements ContactDAO {

	private Log log = LogFactory.getLog(AnnoJdbcContactDAO.class);
	private DataSource dataSource;
	/*
	 * delegate to class which extends MappingSqlQuery<T> 
	 */
	private SelectAllContacts selectAll;

	public AnnoJdbcContactDAO() {
	}
	
	/**
	 * @param dataSource the dataSource to set
	 */
	@Resource(name="dataSource")// like @Autowired
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		selectAll = new SelectAllContacts(dataSource);
		
	}
		
	/**
	 * @return the dataSource
	 */
	public DataSource getDataSource() {
		return dataSource;
	}
	
	@Override
	public List<Contact> findAll() {
		return selectAll.execute();
	}

	@Override
	public List<Contact> findAllWithDetail() {
		return null;
	}

	@Override
	public List<Contact> findByFirstName(String firstName) {
		return null;
	}

	@Override
	public String findFirstNameByID(Long id) {
		return null;
	}

	@Override
	public void insert(Contact contact) {
	}

	@Override
	public void update(Contact contact) {
	}

	@Override
	public void delete(Long contactId) {
	}



	
}
