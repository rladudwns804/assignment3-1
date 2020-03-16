package com.meritamerica.assignment3;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.lang.NumberFormatException;
import java.text.ParseException;
import java.util.Arrays;
import java.util.Date;
import java.io.BufferedReader;


public abstract class BankAccount{
	
	private double bal;
	private double IR;
	private long acNum;
	private int term;
	private Date openedDate;
	private static BankAccount bank;
	
	BankAccount(double bal){
		this.bal = bal;
	}
	
	BankAccount(CDOffering offering, double balance){
		bal = balance;
		IR = offering.getInterestRate();
		term = offering.getTerm();
	}
		
	BankAccount(double bal, double IR){
		
		this.bal = bal;
		this.IR = IR;
	}

	BankAccount(double bal, double IR, Date acOpened){
		
		this.bal = bal;
		this.IR = IR;
		openedDate = acOpened;
	}

	BankAccount(long acNum, double bal, double IR, Date acOpened){
		
		this.acNum = acNum;
		this.bal = bal;
		this.IR = IR;
		openedDate = acOpened;
	}

	

	long getAccountNumber(){
		return acNum;
	}

	double getBalance(){
		return bal;
	}

	double getInterestRate(){
		return IR;
	}

	Date getOpenedOn(){
		
		return openedDate;
	}

	boolean withdraw(double amount){
		
		if (amount <bal)
			return true;
		
		else 
			return false;
		
	}
	
	boolean deposit(double amount){
		if (amount > 0)
			return true;
		
		else 
			return false;
	}

	double futureValue(int years){
		double p = bal;
		double i = IR;
		double power = Math.pow(1+i,years);
		double future = p*power;
		return future;
		
	}
	
	int getTerm() {
		return term;
	}

	static BankAccount readFromString(String accountData) throws ParseException, IOException{
	
	//Should throw a java.lang.NumberFormatException if string cannot be correctly parsed	
	FileReader file = new FileReader(accountData);	
	BufferedReader buffer = new BufferedReader(file);
	
	String line;
	while ((line =buffer.readLine()) != null) {
		
		System.out.println(line);
	}
	
		file.close();	
	
		return  bank;
	}


	
	
	String writeToString() throws IOException {
			FileWriter write = new FileWriter("BankAccount.txt");
			BufferedWriter buffer = new BufferedWriter(write);
			buffer.write(toString());
			buffer.close();
				
			return toString();
		
	}


	
	public String toString() {
		return acNum +"\n" + Arrays.deepToString(MeritBank.getCDOfferings()) + "\n" + MeritBank.numberAccountHolders() + "\n"  ;
	}
}
	













