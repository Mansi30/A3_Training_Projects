package com.capgemini.view;

import com.capgemini.exception.InsufficientOpeningAmountException1;
import com.capgemini.service.BankRunner;
import com.capgemini.service.SBIBank1;

public class Client1 {

	public static void main(String[] args) {
		
		SBIBank1 sbiBank = new SBIBank1();
		
		BankRunner bankRunner = new BankRunner(sbiBank);
		
		try {
			
		System.out.println(sbiBank.createAccount(1, 5000));
		System.out.println(sbiBank.createAccount(2, 3000));	
		
	    
		}catch (InsufficientOpeningAmountException1 io) {

			System.out.println("Minimum balance should be 500/-");
		}
		
		Thread firstThread = new Thread(bankRunner,"First");
		firstThread.start();
		
		Thread secondThread = new Thread(bankRunner,"Second");
		secondThread.start();
	}

}
