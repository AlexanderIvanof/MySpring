package com.alex.spring.beans;

public class Juggler implements Performer {

	private int ball = 3;

	public Juggler() {

	}

	public Juggler(int ball) {
		super();
		this.ball = ball;
	}

	@Override
	public void perform() throws Exception {
		System.out.println("Juggling  " + ball + " beanbags.");
	}

}
