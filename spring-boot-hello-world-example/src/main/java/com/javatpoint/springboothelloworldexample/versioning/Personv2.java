package com.javatpoint.springboothelloworldexample.versioning;

public class Personv2 {
	private Name name;
	
	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}

	public Personv2() {
		super();
	}

	public Personv2(Name name) {
		super();
		this.name = name;
	}

}
