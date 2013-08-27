package com.alex.spring.beans;

public class Saxophone implements Instrument {

	public Saxophone() {
	}
	
	@Override
	public void play() {
		System.out.println(" ... by SAXOPHONE");
	}

}
