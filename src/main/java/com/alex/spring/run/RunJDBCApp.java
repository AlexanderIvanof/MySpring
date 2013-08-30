package com.alex.spring.run;

import java.util.List;

import com.alex.spring.jdbc.Contact;
import com.alex.spring.jdbc.dao.ContactDAO;
import com.alex.spring.jdbc.dao.impl.PlainContactDAO;
/*
 * This class remember a jdbc sample
 */
public class RunJDBCApp {

	static ContactDAO contDAO = new PlainContactDAO();
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		List<Contact> all = contDAO.findAll();
		
		for (Contact contact : all) {
			System.out.println(contact);
		}
		
	}

}
