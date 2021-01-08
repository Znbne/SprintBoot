package com.javatpoint.springboothelloworldexample.versioning;

public class Personv1 {
	public Personv1(String name) {
		super();
		this.name = name;
	}
	public Personv1() {
		super();
	}
	private String name;
	
    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
