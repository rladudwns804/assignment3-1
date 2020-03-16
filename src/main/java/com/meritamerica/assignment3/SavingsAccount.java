package com.meritamerica.assignment3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.StringReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SavingsAccount extends BankAccount {
	
	private static SavingsAccount sAccount;
	private double IR = .01;
	
	
	public SavingsAccount(double bal) {
		super(bal);
	}
	
	public SavingsAccount(long acNum, double bal, double IR, Date acOpened){
		super(acNum, bal, IR, acOpened);


}
	
	
	// Get Balance 
	public double getBalance(){
		return super.getBalance(); 
		
	}
	
	// Get Interest Rate
	double getInterestRate() {
		
		return super.getInterestRate();
	}
	

	boolean deposit (double amount) {
		
		if (amount >0)
			return true;
		else
			return false;
	} 
	
		
	//Withdraw Balance
	boolean withDraw(double amount) {
		if (amount <super.getBalance())			
			return true;
		
		else
			return false;
	}
	
	
	
	
	
	 double futureValue(int years) {
		 
		 double p = getBalance();
			double i = IR;
			double power = Math.pow(1+i,years);
			double future = p*power;
			return future;
		
	}
	 
	 Date getStartDate() {
		 return super.getOpenedOn();
	 }
	 



	long getAccountNumber(){
		
		
		return super.getAccountNumber();
	}


		
	static SavingsAccount readFromString(String accountData) throws ParseException{
		
		
		String[] array = accountData.split(",");
		
		int accNum = Integer.parseInt(array[0]);
		double bal = Double.parseDouble(array[1]);
		double IR = Double.parseDouble(array[2]);
		Date date = new SimpleDateFormat("dd/MM/yyyy").parse(array[3]);
	
					
		
		
		sAccount = new SavingsAccount(accNum, bal, IR, date);
		
		
		return sAccount;
		
	}
	
	
	
	String writeToString() throws IOException {
		
		FileWriter write = new FileWriter("AccountDetails.txt", true);
		BufferedWriter buffer = new BufferedWriter(write);
		buffer.write(toString());
		buffer.close();
		return toString();
		
		}



 
	public String toString() {
		 
		 return getAccountNumber() + ", " + getBalance() + ", "+ getInterestRate() + ", " + getStartDate();
	 }
		
		
	
	
	
	
	
}
