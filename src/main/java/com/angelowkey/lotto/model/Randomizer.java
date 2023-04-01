package com.angelowkey.lotto.model;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Randomizer {
	
	
	public String randomize(String drawType) {
		
		int startNumber=0;
		int endNumber=0;
		int numberOfCombination=0;
		boolean repetetive=false;
		
		String combination = "";
		
		switch(drawType) {
		
			case "ez2":
				startNumber=1;
				endNumber=31;
				numberOfCombination=2;
				repetetive=false;
				break;
			case "swer3":
				startNumber=0;
				endNumber=9;
				numberOfCombination=3;
				repetetive=true;
				break;
			case "4d":
				startNumber=0;
				endNumber=9;
				numberOfCombination=4;
				repetetive=true;
				break;
			case "6d":
				startNumber=0;
				endNumber=9;
				numberOfCombination=6;
				repetetive=true;
				break;
			case "6/42":
				startNumber=1;
				endNumber=42;
				numberOfCombination=6;
				repetetive=false;
				break;
			case "6/45":
				startNumber=1;
				endNumber=45;
				numberOfCombination=6;
				repetetive=false;
				break;
			case "6/49":
				startNumber=1;
				endNumber=49;
				numberOfCombination=6;
				repetetive=false;
				break;
			case "6/55":
				startNumber=1;
				endNumber=55;
				numberOfCombination=6;
				repetetive=false;
				break;
			case "6/58":
				startNumber=1;
				endNumber=58;
				numberOfCombination=6;
				repetetive=false;
				break;
			
		}
	
		ArrayList<Integer> combi = new ArrayList<Integer>();
		
	
		for(int x=1;x<=numberOfCombination;x++) {
		
			int randomNum = ThreadLocalRandom.current().nextInt(startNumber, endNumber + 1);
		
				while(combi.contains(randomNum) && repetetive==false) {
				 randomNum = ThreadLocalRandom.current().nextInt(startNumber, endNumber + 1);
				 System.out.println("match");
				}
				
					combi.add(randomNum);
				
			
			
			System.out.println(randomNum);
			combination+=randomNum+"-";
		}
		
		System.out.println(startNumber);
		System.out.println(endNumber);
		
		combination = combination.substring(0, combination.length()-1);
		
		return combination;
	}

}
