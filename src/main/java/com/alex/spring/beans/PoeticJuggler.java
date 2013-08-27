package com.alex.spring.beans;

public class PoeticJuggler extends Juggler implements Performer {

	private Poem poem;

	public PoeticJuggler() {
	}
	
	public PoeticJuggler(Poem poem){
		super();
		this.poem = poem;
	}
	public PoeticJuggler(Poem poem, int ball) {
		super(ball);
		this.poem = poem;
	}


	@Override
	public void perform() throws Exception {
		super.perform();
		System.out.println("Declare poem....");
		poem.recite();
	}

}
