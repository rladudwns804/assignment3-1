package com.meritamerica.assignment3;

import java.io.IOException;
import java.text.ParseException;
import java.util.Arrays;

public class MeritAmericaBankApp {

   
		
	
	public static void main(String[] args)  {
		
		MeritBank.readFromFile("src/test/testMeritBank_good.txt");
		
		
		 
		  
		
		// System.out.println(Arrays.toString(MeritBank.getCDOfferings()));
		 AccountHolder[] sortedAccount = MeritBank.sortAccountHolders();
		 System.out.println(MeritBank.getCDOfferings().length);
	}
	
	
	
	
	
}