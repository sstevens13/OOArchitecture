package AccountTemplate;

import java.util.Calendar;

public class TestAccounts {
	
	
	public static void main(String args[]) {
		System.out.println("All accounts are initialized with a balance of $100.00\n");
		
		System.out.println("Initializing a savings and checking account that are \n" +
				"less than a day old and invoking getAccountSummary()");
		Calendar accountStartDate = Calendar.getInstance();
		SavingsAccount saveZeroYear = new SavingsAccount(accountStartDate, 100.00);
		CheckingAccount checkingZeroYear = new CheckingAccount(accountStartDate, 100.00);
		saveZeroYear.getAccountSummary();
		checkingZeroYear.getAccountSummary();
		System.out.println();

		System.out.println("Initializing a savings and checking account that are \n" +
				"over 1 year old (less than 2 years old) and invoking getAccountSummary()");
		accountStartDate.set(2012, 0, 0);
		SavingsAccount saveOneYear = new SavingsAccount(accountStartDate, 100.00);
		CheckingAccount checkingOneYear = new CheckingAccount(accountStartDate, 100.00);
		saveOneYear.getAccountSummary();
		checkingOneYear.getAccountSummary();
		System.out.println();
		
		System.out.println("Initializing a savings and checking account that are \n" +
				"over 5 years old (less than 6 years old) and invoking getAccountSummary()");
		accountStartDate.set(2008, 0, 0);
		SavingsAccount saveFiveYear = new SavingsAccount(accountStartDate, 100.00);
		CheckingAccount checkingFiveYear = new CheckingAccount(accountStartDate, 100.00);
		saveFiveYear.getAccountSummary();
		checkingFiveYear.getAccountSummary();
		
		
		
	}
	
}
