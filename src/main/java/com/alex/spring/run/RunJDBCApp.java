package com.alex.spring.run;

import java.util.List;

import com.alex.spring.jdbc.Contact;
import com.alex.spring.jdbc.dao.ContactDAO;
import com.alex.spring.jdbc.dao.impl.PlainContactDAO;

public class RunJDBCApp {

	static ContactDAO contDAO = new PlainContactDAO();
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		List<Contact> all = contDAO.findAll();
		
		System.out.println(all);
	}

}
