package com.alex.spring.beans;

import java.util.List;

public class Outputing {

	private List<City> query;
	private String asdf;
	private City city;
	private List<String> qwer;

	public Outputing() {
	}
	
	/**
	 * @return the query
	 */
	public List<City> getQuery() {
		return query;
	}

	/**
	 * @param query the query to set
	 */
	public void setQuery(List<City> query) {
		this.query = query;
	}

	/**
	 * @return the asdf
	 */
	public String getAsdf() {
		return asdf;
	}

	/**
	 * @param asdf the asdf to set
	 */
	public void setAsdf(String asdf) {
		this.asdf = asdf;
	}

	/**
	 * @return the city
	 */
	public City getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(City city) {
		this.city = city;
	}

	/**
	 * @return the qwer
	 */
	public List<String> getQwer() {
		return qwer;
	}

	/**
	 * @param qwer the qwer to set
	 */
	public void setQwer(List<String> qwer) {
		this.qwer = qwer;
	}
}
