package com.alex.spring.jdbc.dao;

import java.util.List;

import com.alex.spring.jdbc.Contact;

public interface ContactDAO {

	public List<Contact> findAll();
	
	public List<Contact> findByFirstName(String firstName);
	
	public void insert(Contact contact);
	
	public void update(Contact contact);
	
	public void delete(Long contactId);
}
