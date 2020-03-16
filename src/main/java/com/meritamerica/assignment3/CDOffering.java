package com.meritamerica.assignment3;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.lang.NumberFormatException;
import java.text.ParseException;
import java.io.BufferedReader;

public class CDOffering{


	private int term;
	private double interestRate;
	private static CDOffering cdOffering;


	CDOffering(int term, double interestRate){

		this.term = term;
		this.interestRate = interestRate;

	}


	int getTerm(){

		return term;
	}


	double getInterestRate(){
		
		return interestRate;
	}

	
	
	
	static CDOffering readFromString(String cdOfferingDataString) {
		//Should throw a java.lang.NumberFormatException if String cannot be correctly parsed
		
			String[] array = cdOfferingDataString.split(",");
			
			int term = Integer.parseInt(array[0]);
			double interest = Double.parseDouble(array[1]);
			
		cdOffering = new CDOffering(term, interest);
			
			
		return cdOffering;
	}
	


	String writeToString() {
		
		try {
			FileWriter writer = new FileWriter ("CDOffering.txt", true);
			BufferedWriter bufferedWriter = new BufferedWriter(writer);
			bufferedWriter.write(toString()); 
			bufferedWriter.close();
			
		}
		
		catch(IOException e) {
			e.printStackTrace();
			
		}
		return toString();
	}


	public String toString() {
		
		return term + ", " + interestRate + "\n";
	}


















}
