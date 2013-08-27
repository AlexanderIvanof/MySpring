package com.alex.spring.beans;

public class Stage {

	private static Stage stage;
	private long id;
	
	private Stage(){
		id = System.currentTimeMillis();
		System.out.println("Init Stage -->" +id);
	}
	
	public static Stage getInstance(){
		if(stage == null){
			stage = new Stage();
		}
		return stage;
	}
	
}
