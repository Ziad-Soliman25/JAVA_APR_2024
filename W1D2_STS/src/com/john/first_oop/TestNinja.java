package com.john.first_oop;

public class TestNinja {

	public static void main(String[] args) {
		System.out.println("hello");
		
		Ninja ninja1 = new Ninja("bob", "katana", 100);
		ninja1.displayStats();
		
		Ninja ninja2 = new Ninja("alice", "staff", 100);
		
		ninja2.attack(ninja1);

	}

}
