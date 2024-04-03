package com.john.inheritance;

public class Samurai extends Ninja implements Knowledgeable, Trainable {

	public Samurai(String name, String weapon, int powerLevel) {
		super(name, weapon, powerLevel);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void drinkSake() {
		// TODO Auto-generated method stub

	}

	@Override
	public void increasePowerLevel() {
		this.setPowerLevel(getPowerLevel() + 10);
		
	}

}
