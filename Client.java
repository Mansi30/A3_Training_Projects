package com.capgemini.view;

import com.capgemini.exception.InsufficientBalanceException;
import com.capgemini.exception.InsufficientOpeningAmountException;
import com.capgemini.exception.InvalidAccountNumberException;
import com.capgemini.service.Bank;
import com.capgemini.service.SBIBank;

public class Client {

	public static void main(String[] args) {
		
		Bank bank = new SBIBank();
		try {
			
		System.out.println(bank.createAccount(1021, 1000));
		System.out.println(bank.createAccount(1024, 3000));	
		System.out.println("Balance after amount withdrawn = "+bank.withdrawAmount(1021, 100));
		System.out.println("Balance after amount deposited ="+bank.depositAmount(1024, 200));
		
		int[] amt = bank.fundTransfer(1021, 1024, 500);
		
		System.out.println("Sender's Balance = " + amt[0] );
		System.out.println("Receiver's Balance = " + amt[1]);
	    
		}catch(InvalidAccountNumberException ia) {
			
			System.out.println("Account number does not exist.");
			
		}catch(InsufficientBalanceException ib) {
			
			System.out.println("Insufficient Balance.");
			
		}catch (InsufficientOpeningAmountException io) {

			System.out.println("Minimum balance should be 500/-");
		}
	}

}
