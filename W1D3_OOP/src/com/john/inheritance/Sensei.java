package com.john.inheritance;

public class Sensei extends Ninja {
	private String wisdom;

	public Sensei(String schoolName, String name, String weapon, int powerLevel, String wisdom) {
		super(name, weapon, powerLevel);
		this.setSchool(schoolName);
		this.wisdom = wisdom;
		// TODO Auto-generated constructor stub
	}
	
	public void attack(Ninja target) {
		System.out.println(this.getName() + " attacks " + target.getName());
		target.setHealth(target.getHealth() - 487);
		System.out.println(target.getName() + " now has " + target.getHealth() + " hp left");
	}
	
	public void speakWisdom() {
		System.out.println(this.getName() + " says " + this.getWisdomString());
	}
	
	
//	--- GETTERS AND SETTERS ----

	public String getWisdomString() {
		return wisdom;
	}

	public void setWisdomString(String wisdomString) {
		this.wisdom = wisdomString;
	}

}
