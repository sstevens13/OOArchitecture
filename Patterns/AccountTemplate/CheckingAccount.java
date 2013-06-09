package AccountTemplate;

import java.util.Calendar;

public class CheckingAccount extends Account {
	
	// adds a checking account identifier to end of accountID
	public CheckingAccount(Calendar openDate, double balance) {
		this.setup(openDate, balance);
		accountID = accountID + "_CHECK";
	}
	
	/*
	 * there is no interest so currentInterest is always zero
	 * allows for a change in case we return to the glorious days of
	 * of interest on checking accounts
	 */
	public void calcInterest() {}

}
