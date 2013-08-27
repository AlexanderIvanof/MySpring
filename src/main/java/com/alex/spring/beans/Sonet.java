package com.alex.spring.beans;

public class Sonet implements Poem {
	private static String[] sonet ={
		"So close no matter how far",
		"Couldn't be much more from the heart",
		"Forever trusting who we are",
		"And nothing else matters."
	};
	@Override
	public void recite() {
		System.out.println("BEGIN");
		for(String s: sonet){
			System.out.println("\t"+s);
		}
		System.out.println("END.");
	}

}
