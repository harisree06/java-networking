/**
 * 
 */
package account.dto;

import java.io.Serializable;

/**
 * @author haris
 *
 */
public class AccountDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 631170594864295570L;
	private int accountNumber; // account number
	private int pin; // PIN for authentication
	private double availableBalance; // funds available for withdrawal
	private double withdrawAmt; // funds available for withdrawal
	private double depositAmt;
	private String message;
	
	
	 public AccountDTO(int theAccountNumber, int thePIN, 
      double theAvailableBalance, double theTotalBalance)
   {
      accountNumber = theAccountNumber;
      pin = thePIN;
      availableBalance = theAvailableBalance;
      
   }
	public AccountDTO() {
		// TODO Auto-generated constructor stub
	}
	public int getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	/**
	 * @return the pin
	 */
	public int getPin() {
		return pin;
	}
	/**
	 * @param pin the pin to set
	 */
	public void setPin(int pin) {
		this.pin = pin;
	}
	/**
	 * @return the availableBalance
	 */
	public double getAvailableBalance() {
		return availableBalance;
	}
	/**
	 * @param availableBalance the availableBalance to set
	 */
	public void setAvailableBalance(double availableBalance) {
		this.availableBalance = availableBalance;
	}
	/**
	 * @return the totalBalance
	 */
	
	
	  // credits an amount to the account
	   public void deposit(double amount, double balance)
	   {
	      this.setAvailableBalance(balance += amount); // add to total balance
	   } // end method credit

	   // debits an amount from the account
	   public void withdraw(double amount, double balance)
	   {
	    //  availableBalance -= amount; // subtract from available balance
		   this.setAvailableBalance(balance -= amount); 
	     
	   } // end method debit
	   // determines whether a user-specified PIN matches PIN in Account
	   public boolean validatePIN(int userPIN)
	   {
	      if (userPIN == pin)
	         return true;
	      else
	         return false;
	   } // end method validatePIN
	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	/**
	 * @return the withdrawAmt
	 */
	public double getWithdrawAmt() {
		return withdrawAmt;
	}
	/**
	 * @param withdrawAmt the withdrawAmt to set
	 */
	public void setWithdrawAmt(double withdrawAmt) {
		this.withdrawAmt = withdrawAmt;
	}
	/**
	 * @return the depositAmt
	 */
	public double getDepositAmt() {
		return depositAmt;
	}
	/**
	 * @param depositAmt the depositAmt to set
	 */
	public void setDepositAmt(double depositAmt) {
		this.depositAmt = depositAmt;
	}


}
