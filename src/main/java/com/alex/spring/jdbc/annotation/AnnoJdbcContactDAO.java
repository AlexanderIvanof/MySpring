package com.alex.spring.jdbc.annotation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
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
	private SelectContactByFirstName selectByName;
	
	/*
	 * delegate to class which extends SqlUpdate 
	 */
	private UpdateContact update;
	private InsertContact insert;

	/*
	 * delegate to class which extends SqlFunction<T>  
	 */
	private FirstNameById function;
	
	public AnnoJdbcContactDAO() {
	}
	
	/**
	 * @param dataSource the dataSource to set
	 */
	@Resource(name="dataSource")// like @Autowired
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		selectAll = new SelectAllContacts(dataSource);
		selectByName = new SelectContactByFirstName(dataSource);
		update = new UpdateContact(dataSource);
		insert = new InsertContact(dataSource);
		function = new FirstNameById(dataSource);
	}


	@Override
	public List<Contact> findByFirstName(String firstName) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("first_name", firstName);
		return selectByName.executeByNamedParam(map);
	}
	
	@Override
	public List<Contact> findAll() {
		return selectAll.execute();
	}

	@Override
	public void update(Contact contact) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("first_name", contact.getFirstName());
		map.put("last_name", contact.getLastName());
		map.put("id", contact.getId());
		map.put("birth_date", contact.getBirthDate());
		update.updateByNamedParam(map);
		log.info("Contact is update: " + contact);
	}
	
	@Override
	public void insert(Contact contact) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("first_name", contact.getFirstName());
		map.put("last_name", contact.getLastName());;
		map.put("birth_date", contact.getBirthDate());
		KeyHolder keyHolder = new GeneratedKeyHolder();
		insert.updateByNamedParam(map, keyHolder);
		contact.setId(keyHolder.getKey().longValue());
		log.info("Insert new user: " + contact);
		
	}
	

	@Override
	public String findFirstNameByID(Long id) {
		List<String> result = function.execute(id);
		return result.get(0);
	}
	
	@Override
	public void insertWithDetail(Contact contact) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @return the dataSource
	 */
	public DataSource getDataSource() {
		return dataSource;
	}
	
	

	@Override
	public List<Contact> findAllWithDetail() {
		return null;
	}

	@Override
	public void delete(Long contactId) {
	}
	
}
