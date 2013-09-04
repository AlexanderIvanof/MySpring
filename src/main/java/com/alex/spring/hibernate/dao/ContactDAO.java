package com.alex.spring.hibernate.dao;

import java.util.List;

import com.alex.spring.hibernate.domain.Contact;

public interface ContactDAO {

	public List<Contact> findAll();
	
	public List<Contact> findAllWithDetail();
	
	public Contact findbyId(Long id);
	
	public Contact save(Contact contact);
	
	public void delete(Contact contact);

}
