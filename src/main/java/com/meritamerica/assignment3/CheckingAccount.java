package com.meritamerica.assignment3;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

		
public class CheckingAccount extends BankAccount{
	
	private static CheckingAccount cAccount;
	private double IR = .0001;
	
	
	
	public CheckingAccount(double bal) {
		super(bal);
		
	}
	public CheckingAccount(long acNum, double bal, double IR, Date acOpened) {
		
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
	
	

	//Withdraw Balance
	boolean withDraw(double amount) {
		
		return super.withdraw(amount);
			
	}
	
	
		
	boolean deposit (double amount) {
		
		return super.deposit(amount);
		
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
	 
 
	static CheckingAccount readFromString(String accountData)throws ParseException{
		
		String[] array = accountData.split(",");
		
		int accNum = Integer.parseInt(array[0]);
		double bal = Double.parseDouble(array[1]);
		double IR = Double.parseDouble(array[2]);
		Date date = new SimpleDateFormat("dd/MM/yyyy").parse(array[3]);
	
					
		
		
		cAccount = new CheckingAccount(accNum, bal, IR, date);
				
		return cAccount;
		
	}	

	String writeToString() throws IOException {
		FileWriter write = new FileWriter("AccountDetails.txt",true);
		BufferedWriter buffer = new BufferedWriter(write);
		buffer.write(toString());
		buffer.close();		
		return(toString());
	}
		
		
	
 
	public String toString() {
		 
		 
		 return getAccountNumber() + ", " + getBalance() + ", "+ getInterestRate() + ", " + getStartDate();
		 
	 }
		
		
	
	
	
	
	
}
	
