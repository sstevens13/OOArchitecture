package AccountTemplate;

import java.util.Calendar;

public class SavingsAccount extends Account {

	// adds a savings account identifier to end of accountID
	public SavingsAccount(Calendar openDate, double balance) {
		this.setup(openDate, balance);
		accountID = accountID + "_SAVE";
	}
	
	/*
	 * interest rate of savings account is 5%
	 * interest is compounded annually
	 */
	public void calcInterest() {
		interestRate = .05;
		
		// subtract 1 because we don't want to count partial years
		int yearsOfInterest = Calendar.getInstance().get(Calendar.YEAR) - 
				lastAccountUpDate.get(Calendar.YEAR) - 1;
	
		// used to add total days of partial starting year and partial ending year 
		// together, if days >= 365 another year of interest will be added
		int daysOfInterest = 0; 
		if (yearsOfInterest < 0) {
			daysOfInterest = Calendar.getInstance().get(Calendar.DAY_OF_YEAR) - 
					lastAccountUpDate.get(Calendar.DAY_OF_YEAR);
		} else {
			daysOfInterest = (365 - lastAccountUpDate.get(Calendar.DAY_OF_YEAR)) +
					Calendar.getInstance().get(Calendar.DAY_OF_YEAR);  
		}
		yearsOfInterest = yearsOfInterest + daysOfInterest/365;
		
		yearsOfInterest = (yearsOfInterest < 0) ? 0 : yearsOfInterest;
		
		if (yearsOfInterest > 0) {
			currentInterest = balance * Math.pow(1 + interestRate, yearsOfInterest) -
					balance;
		} else {
			currentInterest = 0;
		}
	}

}
