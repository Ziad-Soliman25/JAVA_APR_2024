package com.john.inheritance;

public class TestNinja {

	public static void main(String[] args) {
		
		Ninja ninja1 = new Ninja("Goku", "hands", 9001);
		Ninja ninja2 = new Ninja("Vegeta", "ki", 9000);
		
//		ninja2.attack(ninja1);
		Sensei masterSplinterSensei = new Sensei("CTU", "Master Splinter", "staff", 10000, "pair programming is great!");
		System.out.println(masterSplinterSensei.getName());
		System.out.println(masterSplinterSensei.getSchool());
		
		masterSplinterSensei.attack(ninja1);
		masterSplinterSensei.speakWisdom();

	}

}
