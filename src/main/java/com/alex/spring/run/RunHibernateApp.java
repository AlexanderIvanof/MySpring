package com.alex.spring.run;

import java.util.Date;
import java.util.List;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.alex.spring.hibernate.dao.ContactDAO;
import com.alex.spring.hibernate.domain.Contact;
import com.alex.spring.hibernate.domain.ContactTelDetail;
import com.alex.spring.hibernate.domain.Hobby;

public class RunHibernateApp {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:hibernate/hibernate-context.xml");
		ctx.refresh();
		
		ContactDAO dao = ctx.getBean("contactDAO", ContactDAO.class);
		
//		saveContact(dao);
		
		long start = System.currentTimeMillis();
		List<Contact> list = dao.findAllWithDetail();
//		Contact contact = dao.findbyId(1l);
		long stop = System.currentTimeMillis();
		for (Contact contact : list) {
			System.out.println(contact);
			if(contact.getContactTelDetail() != null){
				for(ContactTelDetail det : contact.getContactTelDetail()){
					System.out.println(">>>>" + det);
				}
			}
			
			if(contact.getHobbies() != null){
				for(Hobby hb : contact.getHobbies()){
					System.out.println(">>>>>>>" + hb);
				}
			}
		}
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>" + (stop - start) + "<<<<<<<<<<<<<<<<<<<<<<<<<<");
		
	}
	
	@SuppressWarnings("unused")
	private static void saveContact(ContactDAO contactDAO){
		Contact contact = new Contact();
		contact.setFirstName("Michel");
		contact.setLastName("Jackson");
		contact.setBirthDate(new Date());
		
		ContactTelDetail conDet1 = new ContactTelDetail("Home", "(044)345-86-55");
		ContactTelDetail conDet2 = new ContactTelDetail("Mobile", "(044)345-86-55");
		contact.addContactTelDetail(conDet1);
		contact.addContactTelDetail(conDet2);
		
		contactDAO.save(contact);
	}

}
