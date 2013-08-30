package com.alex.spring.jdbc.annotation;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.jdbc.object.MappingSqlQuery;

import com.alex.spring.jdbc.Contact;

public class SelectAllContacts extends MappingSqlQuery<Contact> {
	private static final String SQL_SELECT_ALL = "select * from contact";
	
	public SelectAllContacts(DataSource dataSource) {
		super(dataSource, SQL_SELECT_ALL);
	}

	@Override
	protected Contact mapRow(ResultSet rs, int rowNum) throws SQLException {
		Contact contact = new Contact();
		
		contact.setId(rs.getLong("id"));
		contact.setFirstName(rs.getString("first_name"));
		contact.setLastName(rs.getString("last_name"));
		contact.setBirthDate(rs.getDate("birth_date"));
		return contact;
	}


}
