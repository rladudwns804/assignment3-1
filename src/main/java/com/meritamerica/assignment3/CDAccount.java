package com.meritamerica.assignment3;
import java.util.Date;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;



public class CDAccount extends BankAccount{

	private CDOffering offering;
	private int term;
	private double IR;
	private static CDAccount cdAccount;

	public CDAccount(CDOffering offering, double balance) {
		super(offering,balance);
		term = offering.getTerm();
		IR = offering.getInterestRate();
	}
	
	
	public CDAccount(long acNum, double bal, double IR, Date acOpened , int term){
		super(acNum, bal, IR, acOpened);
		this.term =term;
	}

	

	public double getBalance(){
		return super.getBalance();
	}


	double getInterestRate(){
		
		return super.getInterestRate();
	}

	int getTerm(){
		return term;
	}


	
	Date getOpenedOn(){
		return super.getOpenedOn();
	}

	@Override
	boolean withdraw(double amount) {
		return false;
	}
	
	@Override
	boolean deposit(double amount) {
		return false;
	}

	long getAccountNumber(){
		return super.getAccountNumber();
	}


	static CDAccount readFromString(String accountData) throws ParseException{
	
		String[] string = accountData.split(",");
		
		int accNum = Integer.parseInt(string[0]);
		double bal = Double.parseDouble(string[1]);
		double IR = Double.parseDouble(string[2]);
		Date date = new SimpleDateFormat("dd/MM/yyyy").parse(string[3]);
		int term = Integer.parseInt(string[4]);
		
		
		cdAccount = new CDAccount(accNum, bal, IR, date, term);
		
		return cdAccount;
	}
	
	
	
	@Override
	String writeToString() throws IOException{
		
		FileWriter write = new FileWriter("AccountDetails.txt",true);
		BufferedWriter buffer = new BufferedWriter(write);
		buffer.write(toString());
		buffer.close();
		return toString();
		
	}

	

	 double futureValue(){
		double p = super.getBalance();
		double i = super.getInterestRate();
		double n = super.getTerm();
		double power = Math.pow(1+i,n);
		double future = p * power;
			
		return future;
	}

	 
	 public String toString() {
		 
		 return  getAccountNumber() + ", " + getBalance() + ", "+ getInterestRate() + ", " + term + ", " + getOpenedOn();
	 }













}
