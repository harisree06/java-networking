/**
 * 
 */
package account.dto;

import java.util.ArrayList;

import account.dto.AccountDTO;

/**
 * @author haris
 *
 */
public class BankDatabase {
	
	private ArrayList<AccountDTO> accountList = new ArrayList<AccountDTO>();// array of Accounts
	   
	   // no-argument BankDatabase constructor initializes accounts
	   public BankDatabase()
	   {
		   accountList.add(new AccountDTO (12345, 1234, 1000.0, 1200.0) );
		   accountList.add(new AccountDTO (98765, 56789, 200.0, 200.0) );
	    
	   } // end no-argument BankDatabase constructor
	   
	   // retrieve Account object containing specified account number
	   public AccountDTO getAccount(int accountNumber)
	   {
	      // loop through accounts searching for matching account number
	      for (AccountDTO currentAccount : accountList)
	      {
	         // return current account if match found
	         if (currentAccount.getAccountNumber() == accountNumber)
	            return currentAccount;
	      } // end for

	      return null; // if no matching account was found, return null
	   } // end method getAccount

	   // determine whether user-specified account number and PIN match
	   // those of an account in the database
	   public boolean authenticateUser(AccountDTO acct)
	   {
	      // attempt to retrieve the account with the account number
	      AccountDTO userAccount = getAccount(acct.getAccountNumber());

	      // if account exists, return result of Account method validatePIN
	      if (userAccount != null)
	         return userAccount.validatePIN(acct.getPin());
	      else
	         return false; // account number not found, so return false
	   } // end method authenticateUser

	   // return available balance of Account with specified account number
	   public double getAvailableBalance(int userAccountNumber)
	   {
	      return getAccount(userAccountNumber).getAvailableBalance();
	   } // end method getAvailableBalance


	   // credit an amount to Account with specified account number
	   public AccountDTO credit(AccountDTO acct)
	   {
	      getAccount(acct.getAccountNumber()).deposit(acct.getDepositAmt() , acct.getAvailableBalance());
	      return  getAccount(acct.getAccountNumber());
	   } // end method credit

	   // debit an amount from Account with specified account number
	   public AccountDTO debit(AccountDTO acct)
	   {
	      getAccount(acct.getAccountNumber()).withdraw(acct.getWithdrawAmt() , acct.getAvailableBalance());
	      return  getAccount(acct.getAccountNumber());
	   } // end method debit

}
