package com.alex.spring.jdbc;

import java.io.Serializable;

/**
 * POJO for 
 * 
 * @author Alexander Ivanov
 *
 */
public class ContactTelDetail implements Serializable {
	
	/* Serial for ContactTelDetail.class */
	private static final long serialVersionUID = -8712627800869412268L;
	
	private Long id;
	private Long contactId;
	private String telType;
	private String telNumber;
	
	public ContactTelDetail() {
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ContactTelDetail [id=" + id + ", Contact id:" + contactId
				+ ", Type=" + telType + ", Number=" + telNumber + "]";
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
	 * @return the contactId
	 */
	public Long getContactId() {
		return contactId;
	}

	/**
	 * @param contactId the contactId to set
	 */
	public void setContactId(Long contactId) {
		this.contactId = contactId;
	}

	/**
	 * @return the telType
	 */
	public String getTelType() {
		return telType;
	}

	/**
	 * @param telType the telType to set
	 */
	public void setTelType(String telType) {
		this.telType = telType;
	}

	/**
	 * @return the telNumber
	 */
	public String getTelNumber() {
		return telNumber;
	}

	/**
	 * @param telNumber the telNumber to set
	 */
	public void setTelNumber(String telNumber) {
		this.telNumber = telNumber;
	}
	
}
