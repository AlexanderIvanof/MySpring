package com.alex.spring.hibernate.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.alex.spring.hibernate.dao.ContactDAO;
import com.alex.spring.hibernate.domain.Contact;
import com.alex.spring.jdbc.annotation.AnnoJdbcContactDAO;

@Repository("contactDAO")
@Transactional
public class ContactDAOImpl implements ContactDAO {

	private Log log = LogFactory.getLog(AnnoJdbcContactDAO.class);
	private SessionFactory sessionFactory;

	/**
	 * @return the sessionFactory
	 */
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	/**
	 * @param sessionFactory the sessionFactory to set
	 */
	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly = true)
	public List<Contact> findAll() {
		log.info(">>>>>>>>>>>>>Begin select");
		return sessionFactory.getCurrentSession().createQuery("from Contact c")
				.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly = true)
	public List<Contact> findAllWithDetail() {
		return sessionFactory.getCurrentSession()
				.getNamedQuery("Contact.findAllWithDetail").list();
	}

	@Override
	@Transactional(readOnly = true)
	public Contact findbyId(Long id) {
		return (Contact) sessionFactory.getCurrentSession()
				.getNamedQuery("Contact.findById").setParameter("id", id)
				.uniqueResult();
	}

	@Override
	public Contact save(Contact contact) {
		log.info(">>>>>>>>>>>>" + contact.getId());
		sessionFactory.getCurrentSession().saveOrUpdate(contact);
		log.info(">>>>>>>>>>>>" + contact.getId());
		return contact;
	}

	@Override
	public void delete(Contact contact) {

	}

}
