package com.alex.spring.run;

import java.sql.Date;
import java.util.GregorianCalendar;
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

		/* method call insert into db */
//		callInsert(contDAO);
		
		List<Contact> list = contDAO.findAll();// <<<<<<<chenge method here
		if (list != null) {

			for (Contact contact : list) {
				System.out.println(contact);
				List<ContactTelDetail> teleph = contact.getContactTelDetail();
				if (teleph != null) {
					for (ContactTelDetail contactTelDetail : teleph) {
						System.out.println(contactTelDetail);
					}

				}
			}
		}
		/* method call updating db */
//		callUpdate(contDAO);
		
		System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
	}
	
	@SuppressWarnings("unused")
	private static void callInsert(ContactDAO contactDAO){
		Contact rid = new Contact();
		rid.setFirstName("Rid");
		rid.setLastName("Giffter");
		rid.setBirthDate(new Date(new GregorianCalendar(1977, 11, 25).getTimeInMillis()));
		contactDAO.insert(rid);
	}
	
	@SuppressWarnings("unused")
	private static void callUpdate(ContactDAO contactDAO){
		Contact tom = new Contact();
		tom.setId(4l);
		tom.setFirstName("Tom");
		tom.setLastName("Cruise");
		tom.setBirthDate(new Date(new GregorianCalendar(1964, 11, 11).getTimeInMillis()));
		
		contactDAO.update(tom);
	}

}
