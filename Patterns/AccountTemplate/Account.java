package AccountTemplate;

import java.text.DecimalFormat;
import java.util.Calendar;

public abstract class Account {
	public static int accountCounter = 1000;
	protected String accountID;
	protected double balance;
	protected double currentInterest;
	protected double interestRate;
	protected Calendar lastAccountUpDate;
	DecimalFormat df = new DecimalFormat("#.##");
	
	public void setup(Calendar openDate, double balance) {
		accountID = Integer.toString(accountCounter);
		accountCounter++;
		this.balance = balance;
		interestRate = 0.0;
		currentInterest = 0.0;
		lastAccountUpDate = openDate;
	}
	
	public void getAccountSummary() {
		calcInterest();
		updateBalance();
		printSummary();
	}
	
	public void updateBalance() {
		balance = balance + currentInterest;
		currentInterest = 0.0;
		lastAccountUpDate = Calendar.getInstance();
	}
	
	public void printSummary() {
		System.out.println("The current account balance of account " + accountID + " is: $" + String.format("%.2f", balance));
	}
	
	public abstract void calcInterest();
		
}
