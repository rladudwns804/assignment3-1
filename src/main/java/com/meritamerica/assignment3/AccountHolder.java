package com.meritamerica.assignment3;
import java.util.Arrays;
import java.util.Date;
import java.util.Objects;



public class AccountHolder implements Comparable<AccountHolder> {
	
	private String firstName;
	private String middleName;
	private String lastName;
	private String ssn;
	private CheckingAccount[] cAccount = new CheckingAccount[10];
	private SavingsAccount[] sAccount = new SavingsAccount[10];
	private CDAccount[] cdAccount = new CDAccount[10];
	private double checkingTotalBalance;
	private double savingsTotalBalance; 
	private int numberOfSavingsAccount = 0;
	private int numberOfCheckingAccounts=0;
	private int numberOfCDAccounts = 0;
	private double cdTotalBalance = 0;
	
	//AccountHolder Constructor
	public AccountHolder (String firstName, String middleName, String lastName, String ssn)
	{	
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName; 
		this.ssn = ssn;
		
	}
	
		
	void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	String getFirstName() {
		return firstName;}
	
	
	void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	
	
	String getMiddleName() {
		return middleName;
	}
	
	void setLastName(String lastName) {
		this.lastName = lastName;
		
	}
	
	String getLastName() {
		return lastName;
	}
	
	
	void setSSN(String ssn) {
		this.ssn = ssn;
	}

	String getSSN(){
		return ssn;
	}
	
	CheckingAccount addCheckingAccount(double openingBalance){
		int count=0;
		int numberofCheckingAccount =0;
		int totalBalance = 0;
		
		for(int i = 0; i<cAccount.length; i++) {
			
			if(cAccount[i]!=null) {
				totalBalance += cAccount[i].getBalance();
				count++;
				numberofCheckingAccount++;
			
			}
			
			else break;
		}
		
		
		
		if(openingBalance + totalBalance + savingsTotalBalance < 250000) {
			cAccount[count]=new CheckingAccount(openingBalance);
			this.checkingTotalBalance = totalBalance + openingBalance;
			this.numberOfCheckingAccounts = numberofCheckingAccount + 1;
		}
		
		return cAccount[count];
		
	}
	
	


	

	CheckingAccount addCheckingAccount(long acctNumber,double openingBalance, double IR, Date date){
		int count=0;
		int numberofCheckingAccount =0;
		int totalBalance = 0;
		
		for(int i = 0; i<cAccount.length; i++) {
			
			if(cAccount[i]!=null) {
				totalBalance += cAccount[i].getBalance();
				count++;
				numberofCheckingAccount++;
			}
			
			else break;
		}
		
		if(openingBalance + totalBalance + savingsTotalBalance < 250000) {
			cAccount[count]=new CheckingAccount(acctNumber, openingBalance, IR, date);
			this.checkingTotalBalance = totalBalance + openingBalance;
			this.numberOfCheckingAccounts = numberofCheckingAccount;
		}
		
		return cAccount[count];
		
	}
	




	CheckingAccount addCheckingAccount(CheckingAccount cAccount){
		
		double totalBalance = 0;
		int count = 0;
		int numberOfCheckingAccounts = 0;
		
		
		
		for (int i = 0; i<this.cAccount.length; i++) {
		
			if(this.cAccount[i] != null) {
				totalBalance += this.cAccount[i].getBalance();
				count++;
				numberOfCheckingAccounts++;
				
			}
			else break;
		}
		
		
			
			if (cAccount.getBalance() + totalBalance + savingsTotalBalance < 250000) {
				this.cAccount[count] = cAccount;
				this.checkingTotalBalance = totalBalance + cAccount.getBalance();
				this.numberOfCheckingAccounts = numberOfCheckingAccounts + 1;
			}
				
		else System.out.println("Cannot make new account");

			return cAccount;
	}
			
		
	CheckingAccount[] getCheckingAccounts(){
		return cAccount;
		}
	


	int getNumberOfCheckingAccounts(){
		
		return numberOfCheckingAccounts;
	}
	

	double getCheckingBalance(){
		
		return cAccount[0].getBalance();
	}


	
	
SavingsAccount addSavingsAccount(double openingBalance){

		
		int count = 0;
		double totalBalance = 0;
		int numsavings=0;
		for (int i=0; i<sAccount.length; i++) {
			if (sAccount[i] != null) {
				count++;
				totalBalance = sAccount[i].getBalance();
				numsavings++;
			}
			
			else break;
		}
		
		if(openingBalance + totalBalance + savingsTotalBalance <250000) {
			sAccount[count] = new SavingsAccount(openingBalance);
			this.savingsTotalBalance = totalBalance + openingBalance;
			this.numberOfSavingsAccount = numsavings + 1;
		}
		
		return sAccount[count];
		
	}
	
	
	
	SavingsAccount addSavingsAccount(long acctNumber,double openingBalance, double IR, Date date){

		
		int count = 0;
		double totalBalance = 0;
		int numsavings=0;
		for (int i=0; i<sAccount.length; i++) {
			if (sAccount[i] != null) {
				count++;
				totalBalance += sAccount[i].getBalance();
				numsavings++;
			}
			
			else break;
		}
		
		if(openingBalance + totalBalance + checkingTotalBalance <250000) {
			sAccount[count] = new SavingsAccount(acctNumber, openingBalance,IR, date);
			this.savingsTotalBalance = totalBalance + openingBalance;
			this.numberOfSavingsAccount = numsavings + 1;
		}
		
		return sAccount[count];
		
	}

	
	
	
	SavingsAccount addSavingsAccount(SavingsAccount sAccount){
		int count = 0;
		int numberOfSavingsAccount = 0;
		int totalbalance = 0;
		
		
		
		for (int i =0; i< this.sAccount.length; i++){
		
			if(this.sAccount[i] != null){
				totalbalance+= this.sAccount[i].getBalance();
				count++;
				numberOfSavingsAccount++;
				
			}
			else break;
		}
		
		

		if(sAccount.getBalance() + totalbalance + checkingTotalBalance < 250000){

			this.sAccount[count] = sAccount;
			this.numberOfSavingsAccount = numberOfSavingsAccount + 1;
			this.savingsTotalBalance = totalbalance + sAccount.getBalance(); 
		}
		
		return sAccount;
		
	}
		
		
	

	SavingsAccount[] getSavingsAccounts() {
		return sAccount;
	}


	int getNumberOfSavingsAccounts(){

		return numberOfSavingsAccount;
	}

		

	double getcheckingTotalBalance(){

		return checkingTotalBalance;
	}	


	double getsavingsTotalBalance(){
	
		return savingsTotalBalance;
	}



	CDAccount addCDAccount(long acNum, double bal, double IR, Date acOpened , int term){
		double totalbalance = 0;
		int count = 0;
		int numcdaccount =1;
		
		for(int i = 0; i <cdAccount.length; i++) {
			
			if (cdAccount[i] != null) {
				totalbalance += cdAccount[i].getBalance();
				count++;
				numcdaccount++;
			}
			else break;
		}
		
		if(bal + totalbalance <250000) {
			cdAccount[count] = new CDAccount(acNum, bal, IR , acOpened , term);
			this.cdTotalBalance = totalbalance + bal;
		}
		
		return cdAccount[count];
	}
	
	
	CDAccount addCDAccount(CDOffering offering, double openingBalance){
		double totalbalance = 0;
		int count = 0;
		int numcdaccount =1;
		
		for(int i = 0; i <cdAccount.length; i++) {
			
			if (cdAccount[i] != null) {
				totalbalance += cdAccount[i].getBalance();
				count++;
				numcdaccount++;
			}
			else break;
		}
		
		if(openingBalance + totalbalance <250000) {
			cdAccount[count] = new CDAccount(offering,openingBalance);
			this.cdTotalBalance = totalbalance + openingBalance;
		}
		
		return cdAccount[count];
	}
	
	

	CDAccount addCDAccount(CDAccount cdAccount){
		int count = 0;
		int numberOfCDAccounts =0;
		double totalBalance = 0;
			
		
		for (int i = 0; i < this.cdAccount.length; i++){

			if(this.cdAccount[i] != null){
				totalBalance += this.cdAccount[i].getBalance();
				count++;
				numberOfCDAccounts++;
				
			}	

			else break;

		}
		
		
		
		this.cdAccount[count] = cdAccount;
		this.numberOfCDAccounts = numberOfCDAccounts + 1;
		this.cdTotalBalance = totalBalance + cdAccount.getBalance();
		System.out.println(checkingTotalBalance);
		return cdAccount;
	}

	
	CDAccount[] getCDAccounts(){
		return cdAccount;
		
	}
	
	
	int getNumberOfCDAccounts(){

		return numberOfCDAccounts;
		
		
	}
	

	double getCDBalance(){
		return 3;
		
	}

	
	double getCombinedBalance(){
		
		return savingsTotalBalance + checkingTotalBalance + cdTotalBalance;
	}
	
	String getCheckingStrings(){
		
		return Arrays.deepToString(cAccount);
		
		
	}
	
	String getSavingsStrings() {
		
		return Arrays.deepToString(sAccount);
		
		}
	
	String getCDStrings() {
		return Arrays.deepToString(cdAccount);
	}


	public String toString() {
		
		
		return  
				 firstName + " " + middleName + " " + lastName + ", " + ssn +"\n" + getNumberOfCheckingAccounts() + 
				 "\n" + "\n" + getCheckingStrings() +"\n" + getSavingsStrings() + "\n" + getNumberOfCDAccounts() + "\n" + 
				 "\n" + getCDStrings();
				
		
		
	}


	@Override
	public int compareTo(AccountHolder o) {
		if (this.getCombinedBalance() > o.getCombinedBalance()) 
			return 1;
		
		
		else if (this.getCombinedBalance() == o.getCombinedBalance())
			return 0;
		
		else
			return -1;
	}
	
	
	
	
	
	
	
	
}	
	
	
	
	
	

