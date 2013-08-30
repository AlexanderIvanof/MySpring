package com.alex.spring.run;

import java.util.List;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.alex.spring.jdbc.Contact;
import com.alex.spring.jdbc.ContactTelDetail;
import com.alex.spring.jdbc.dao.ContactDAO;

public class RunJDBCSpringAnnotation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		@SuppressWarnings("resource")
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:jdbc/jdbc_context_annotation.xml");
		ctx.refresh();
		
		ContactDAO contDAO = ctx.getBean("contactDAO", ContactDAO.class);
		
		List<Contact> list = contDAO.findAll();
		for (Contact contact : list) {
			System.out.println(contact);
			List<ContactTelDetail> teleph = contact.getContactTelDetail(); 
			if(teleph != null){
				for (ContactTelDetail contactTelDetail : teleph) {
					System.out.println(contactTelDetail);
				}
				
			}
		}
		
		System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
	}

}
