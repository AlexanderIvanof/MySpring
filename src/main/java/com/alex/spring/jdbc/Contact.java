package com.alex.spring.jdbc;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

/**
 * POJO for spring_db.contact 
 * 
 * @author Alexander Ivanov
 *
 */
public class Contact implements Serializable {
	
	/* Serial for contact */
	private static final long serialVersionUID = -9175607211157005848L;
	
	private Long id;
	private String firstName;
	private String lastName;
	private Date birthDate;
	private List<ContactTelDetail> contactTelDetail;

	public Contact() {
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Contact [id=" + id + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", Birthday:" + birthDate
				+ ", contactTelDetail=" + contactTelDetail + "]";
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the secondName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param secondName the secondName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the birthDate
	 */
	public Date getBirthDate() {
		return birthDate;
	}

	/**
	 * @param birthDate the birthDate to set
	 */
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	/**
	 * @return the contactTelDetail
	 */
	public List<ContactTelDetail> getContactTelDetail() {
		return contactTelDetail;
	}

	/**
	 * @param contactTelDetail the contactTelDetail to set
	 */
	public void setContactTelDetail(List<ContactTelDetail> contactTelDetail) {
		this.contactTelDetail = contactTelDetail;
	}
	
	
}
