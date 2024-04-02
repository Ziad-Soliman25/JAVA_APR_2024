package com.john.first_oop;

public class Ninja {
	// member variables
	private String name;
	private String weapon;
	private Integer health;
	private static int numberOfNinjasGraduated = 0;

	public Ninja(String name, String weapon, Integer health) {
		this.name = name;
		this.weapon = weapon;
		this.health = health;
	}
	
	// === METHODS ====
    public void displayStats() {
        System.out.println(this.getName() + " has: \n " + this.getWeapon() + " as their weapon and\n " + this.getHealth() + " hp");
    }

    public Ninja attack(Ninja target){
        System.out.println(this.getName() + " attacks " + target.getName());
        target.setHealth(target.getHealth() - 10);
        System.out.println(target.getName() + " now has " + target.getHealth() + " hp left");
        return this;
    }

	// === GETTERS AND SETTERS ===
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getWeapon() {
		return weapon;
	}

	public void setWeapon(String weapon) {
		this.weapon = weapon;
	}

	public Integer getHealth() {
		return health;
	}

	public void setHealth(Integer health) {
		this.health = health;
	}

	public static int getNumberOfNinjasGraduated() {
		return numberOfNinjasGraduated;
	}

	public static void setNumberOfNinjasGraduated(int numberOfNinjasGraduated) {
		Ninja.numberOfNinjasGraduated = numberOfNinjasGraduated;
	}

}
