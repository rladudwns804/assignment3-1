package com.meritamerica.assignment3;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Random;
import java.util.Date;

class MeritBank {


	private static AccountHolder[] ah;
	public static CDOffering[] cdOfferings;
	private static long accountNum;
	private static int numOfAccountHolder;
	private static String hello = "hello";
	


	static void addAccountHolder(AccountHolder account){
		int numAccount = 0;
		int count = 0;
		for(int i =0; i< ah.length; i++){
		
			if(ah[i] != null){

				count++;
			}
			
			else
				break;
			
	}
		numOfAccountHolder = numAccount + 1;
		ah[count] = account;
	}
	

	static AccountHolder[] getAccountHolders(){
		return ah;
		
	}
	
	static AccountHolder getAccounts(int i ) {
		return ah[i];
	}
	
	

	static CDOffering[] getCDOfferings(){
		return cdOfferings;
		
	}

	static CDOffering getBestCDOffering(double depositAmount){
		CDOffering bestCDOffering = null;
		double bestValue = 0;
				
		for(CDOffering cd : cdOfferings) {
			double futureValue = futureValue(depositAmount, cd.getInterestRate(),cd.getTerm());
			
			if (futureValue > bestValue) {
				bestValue =futureValue;
				bestCDOffering = cd;
				
				
		}
			
		}	
		
		return bestCDOffering;
		
	}
		
		
		
	static CDOffering getSecondBestCDOffering(double depositAmount){
			
		CDOffering bestCDOffering = null;
		CDOffering secondCDOffering = null;
		double bestvalue = 0;
		double secondBest =0;
		
		
		
		for(CDOffering cd: cdOfferings) {
			double futureValue = futureValue(depositAmount, cd.getInterestRate(), cd.getTerm());
			if (futureValue > bestvalue && secondBest <= bestvalue || secondBest >= futureValue) {
				bestCDOffering = cd;
				bestvalue =futureValue;
				secondBest = futureValue;
			}/*
			else if(secondBest < bestvalue && secondBest > futureValue) {
				secondCDOffering = cd;
				secondBest = futureValue;
			}*/
		}
		
		return secondCDOffering;
					
	}
		
	

	static void clearCDOfferings(){
		
		cdOfferings = null;
		
		
	}

	static void setCDOfferings(CDOffering offerings){
		
		int count = 0;
		for(int i = 0; i < cdOfferings.length; i++) {
			if (cdOfferings[i] != null) { 
				count++;
			}
			
			else
				break;
					
		}
		
		cdOfferings[count] = offerings;
		
		}
	
	
				
	static void setNextAccountNumber(long nextAccountNumber)
	{
		accountNum = nextAccountNumber;
	}
	
	
	
	static long getNextAccountNumber(){
		
		return accountNum;
	}
		
			

	static double totalBalances(){
		double totalBalance =0;
		
		
		for(int i =0; i<ah.length; i++) {
			
			if(ah[i] != null) {
			totalBalance += ah[i].getCombinedBalance();
		}
			
			else { break;
			}
		}
		
		return totalBalance;
			
	
			
		
	} 
	
	
	
	


	
	static boolean readFromFile(String fileName)   {
		
		int count = 0;
		try {
		FileReader read = new FileReader(fileName);
		BufferedReader buffer = new BufferedReader(read);
		String line;
		while((line = buffer.readLine())!=null) {
		
			String[] array = line.split(",");
			
			
			if(count ==0) {
			long accNum = Long.parseLong(array[0]);
			setNextAccountNumber(accNum);
			}
			
			else if(count == 1) {
			int numCDOffering = Integer.parseInt(array[0]);
			CDOffering[] cdO = new CDOffering[numCDOffering];
			cdOfferings = cdO;
			
			}
			
			else if(count ==2) {
			int term = Integer.parseInt(array[0]);
			double offer1 = Double.parseDouble(array[1]);
			CDOffering cd1 = new CDOffering(term, offer1);
			setCDOfferings(cd1);
			}
			
			else if(count ==3) {
			
			int term2 = Integer.parseInt(array[0]);
			double offer2 = Double.parseDouble(array[1]);
			CDOffering cd2 = new CDOffering(term2,offer2);
			setCDOfferings(cd2);
			
			}
			
			else if(count ==4) {
			int term3 = Integer.parseInt(array[0]);
			double offer3 = Double.parseDouble(array[1]);
			CDOffering cd3 = new CDOffering(term3,offer3);
			setCDOfferings(cd3);
			
			}
			
			else if(count ==5) {
				int numAccountHolder = Integer.parseInt(array[0]);
				AccountHolder[] ac = new AccountHolder[numAccountHolder];
				ah = ac;
			}
			
			else if(count ==6) {
						
			String lastName = array[0];
			String middleName = array[1];
			String firstName = array[2];
			String ssn = array[3];
			AccountHolder accountHolder = new AccountHolder(firstName, middleName, lastName, ssn);
			addAccountHolder(accountHolder);
			
			}
			
			else if (count == 7) {
				
				int numOfChecking = Integer.parseInt(array[0]);
			}
			
			
			else if (count == 8) {
				int accNum = Integer.parseInt(array[0]);
				double bal = Double.parseDouble(array[1]);
				double IR = Double.parseDouble(array[2]);
				Date date = new SimpleDateFormat("dd/MM/yyyy").parse(array[3]);
				
				ah[0].addCheckingAccount(accNum, bal, IR, date);
				
			}
			
			
			else if (count ==9) {
				
				int numOfSavings = Integer.parseInt(array[0]);
								
			}
			
						
			else if (count == 10) {
				int accNum = Integer.parseInt(array[0]);
				double bal = Double.parseDouble(array[1]);
				double IR = Double.parseDouble(array[2]);
				Date date = new SimpleDateFormat("dd/MM/yyyy").parse(array[3]);
				ah[0].addSavingsAccount(accNum, bal, IR, date);
			}
			
			else if (count == 11) {
				int accNum = Integer.parseInt(array[0]);
				double bal = Double.parseDouble(array[1]);
				double IR = Double.parseDouble(array[2]);
				Date date = new SimpleDateFormat("dd/MM/yyyy").parse(array[3]);
				ah[0].addSavingsAccount(accNum, bal, IR, date);
			}
			
			else if (count == 12) {
				
				int numOfCD = Integer.parseInt(array[0]);
			}
			
			else if (count == 13) {
				String lastName = array[0];
				String middleName = array[1];
				String firstName = array[2];
				String ssn = array[3];
				AccountHolder accountHolder2 = new AccountHolder(firstName, middleName, lastName, ssn);
				addAccountHolder(accountHolder2);
			}
			
			else if (count == 14)
			{
				int numOfChecking = Integer.parseInt(array[0]);			
				
			}
			
			else if (count == 15) {
				int accNum = Integer.parseInt(array[0]);
				double bal = Double.parseDouble(array[1]);
				double IR = Double.parseDouble(array[2]);
				Date date = new SimpleDateFormat("dd/MM/yyyy").parse(array[3]);
				ah[1].addCheckingAccount(accNum, bal, IR, date);
			}
			
			else if (count == 16) {
				int accNum = Integer.parseInt(array[0]);
				double bal = Double.parseDouble(array[1]);
				double IR = Double.parseDouble(array[2]);
				Date date = new SimpleDateFormat("dd/MM/yyyy").parse(array[3]);
				ah[1].addCheckingAccount(accNum, bal, IR, date);
			}
			
			else if (count == 17) {
				int numOfSavings =Integer.parseInt(array[0]);
			}
			
			else if (count == 18) {
				int accNum = Integer.parseInt(array[0]);
				double bal = Double.parseDouble(array[1]);
				double IR = Double.parseDouble(array[2]);
				Date date = new SimpleDateFormat("dd/MM/yyyy").parse(array[3]);
				ah[1].addSavingsAccount(accNum, bal, IR, date);
				
			}
			
			
			else if (count ==19) {
				int accNum = Integer.parseInt(array[0]);
				double bal = Double.parseDouble(array[1]);
				double IR = Double.parseDouble(array[2]);
				Date date = new SimpleDateFormat("dd/MM/yyyy").parse(array[3]);
				ah[1].addSavingsAccount(accNum, bal, IR, date);
			}
			
			else if (count ==20) {
				int accNum = Integer.parseInt(array[0]);
				double bal = Double.parseDouble(array[1]);
				double IR = Double.parseDouble(array[2]);
				Date date = new SimpleDateFormat("dd/MM/yyyy").parse(array[3]);
				ah[1].addSavingsAccount(accNum, bal, IR, date);
			}
			
			else if(count==21) {
				int numOfCD = Integer.parseInt(array[0]);
			}
			
			else if (count==22) {
				int accNum = Integer.parseInt(array[0]);
				double bal = Double.parseDouble(array[1]);
				double IR = Double.parseDouble(array[2]);
				Date date = new SimpleDateFormat("dd/MM/yyyy").parse(array[3]);
				int term = Integer.parseInt(array[4]);
				ah[1].addCDAccount(accNum, bal, IR, date, term);
				
			}
			
			else if (count == 23) {
				int accNum = Integer.parseInt(array[0]);
				double bal =Double.parseDouble(array[1]);
				double IR = Double.parseDouble(array[2]);
				Date date = new SimpleDateFormat("dd/MM/yyyy").parse(array[3]);
				int term = Integer.parseInt(array[4]);				
				ah[1].addCDAccount(accNum, bal, IR, date, term);
			}
			
			count++;
			
	}
		
		buffer.close();
	}
		
		catch(IOException e) {
			e.printStackTrace();
			return false;
		}
		
		catch(ParseException e) {
			e.printStackTrace();
			
			return false;
		}
		
		catch(NumberFormatException e) {
			e.printStackTrace();
			
			return false;
		}
		
		
		
						
		return true;
	}
	
	
	

	
	
	static boolean writeToFile(String fileName) {
		try {
		FileWriter write = new FileWriter(fileName, true);
		BufferedWriter buffer = new BufferedWriter(write);
		
		buffer.write(hello);
		buffer.close();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
		return true;
	}
	
	
	
	
	
	static AccountHolder[] sortAccountHolders() {
		Arrays.sort(ah);
		return ah;
	}
	
	
	
	static int numberAccountHolders() {
	
		
		return numOfAccountHolder;
	}
	
	
	
	
	




	static double futureValue(double presentValue, double interestRate, int term) {
		double p = presentValue;
		double i = interestRate/100;
		double n = term;
		double power = Math.pow(1+i,n);
		double future = p * power;
			
		return future;
	
	}


}
