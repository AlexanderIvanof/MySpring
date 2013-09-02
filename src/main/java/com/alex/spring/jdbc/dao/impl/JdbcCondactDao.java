package com.alex.spring.jdbc.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.BeanCreationException;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import com.alex.spring.jdbc.Contact;
import com.alex.spring.jdbc.ContactTelDetail;
import com.alex.spring.jdbc.dao.ContactDAO;

public class JdbcCondactDao implements ContactDAO {

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
	public void afterInitMethod() throws Exception {
		if (dataSource == null) {
			throw new BeanCreationException("DataSource must be set");
		}
	}

	/*
	 * Use simple query fof JdbcTemplate
	 * 
	 * @see com.alex.spring.jdbc.dao.ContactDAO#findFirstNameByID(java.lang.Long)
	 */
	@Override
	public String findFirstNameByID(Long id) {
		String result = jdbcTemp.queryForObject(
				"select first_name from contact where id = ?",
				new Object[] { id }, String.class);
		return result;
	}

	/*
	 * Use RowMapper<T>
	 * 
	 * (non-Javadoc)
	 * @see com.alex.spring.jdbc.dao.ContactDAO#findAll()
	 */
	@Override
	public List<Contact> findAll() {
		String sql = "select * from contact";
		
		return jdbcTemp.query(sql, new ContactMapper());
	}
	
	private static final class ContactMapper implements RowMapper<Contact>{

		@Override
		public Contact mapRow(ResultSet rs, int rowNum) throws SQLException {
			Contact contact = new Contact();
			contact.setId(rs.getLong("id"));
			contact.setFirstName(rs.getString("first_name"));
			contact.setLastName(rs.getString("last_name"));
			contact.setBirthDate(rs.getDate("birth_date"));
			return contact;
		}
		
	}
	
	/*
	 * Use  ResultSetExtractor<T>
	 * (non-Javadoc)
	 * @see com.alex.spring.jdbc.dao.ContactDAO#findAllWithDetail()
	 */
	@Override
	public List<Contact> findAllWithDetail() {
		String sql = "select c.id, c.first_name, c.last_name, c.birth_date," +
				" t.id as contact_tel_id, t.tel_type, t.tel_number" +
				" from contact c left join contact_tel_detail t on c.id = t.contact_id";
		return jdbcTemp.query(sql, new ContactWithDetailExtractor());
	}
	

	private static final class ContactWithDetailExtractor implements ResultSetExtractor<List<Contact>>{

		@Override
		public List<Contact> extractData(ResultSet rs) throws SQLException,
				DataAccessException {
			Map<Long, Contact> map = new HashMap<Long, Contact>();
			Contact cont = null;
			
			while(rs.next()){
				Long id = rs.getLong("id");
				cont = map.get(id);
				
				if(cont == null){
					cont = new Contact();
					cont.setId(id);
					cont.setFirstName(rs.getString("first_name"));
					cont.setLastName(rs.getString("last_name"));
					cont.setBirthDate(rs.getDate("birth_date"));
					cont.setContactTelDetail(new ArrayList<ContactTelDetail>());
					map.put(id, cont);
				}
				
				// set telephone number
				Long contactTelId = rs.getLong("contact_tel_id");
				if(contactTelId > 0){
					ContactTelDetail contTel = new ContactTelDetail();
					contTel.setId(contactTelId);
					contTel.setContactId(id);
					contTel.setTelType(rs.getString("tel_type"));
					contTel.setTelNumber(rs.getString("tel_number"));
					cont.getContactTelDetail().add(contTel);
				}
			}
			return new ArrayList<Contact>(map.values());
		}
		
	}
	
	@Override
	public List<Contact> findByFirstName(String firstName) {
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

	@Override
	public void insertWithDetail(Contact contact) {
		// TODO Auto-generated method stub
		
	}


}
