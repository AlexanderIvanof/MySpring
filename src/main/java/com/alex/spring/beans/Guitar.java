package com.alex.spring.beans;

public class Guitar implements Instrument {

	@Override
	public void play() {
		System.out.println("... by guitar.");
	}

}
