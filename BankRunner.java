package com.capgemini.service;

import com.capgemini.exception.InsufficientBalanceException1;
import com.capgemini.exception.InvalidAccountNumberException1;

public class BankRunner implements Runnable{
	
	SBIBank1 bankObj;
	
    public BankRunner(SBIBank1 bank) {
		super();
		this.bankObj = bank;
	}

	@Override
	public void run() {
		
		try {
			
			if(Thread.currentThread().getName().equals("First")){
				
				System.out.println("Balance(after withdrawn) = "+bankObj.withdrawAmount(1, 2000));
				
			}else if(Thread.currentThread().getName().equals("Second")){
				
				System.out.println("Balance(after withdrawn) = "+bankObj.withdrawAmount(2, 250));
			}
		}catch(InvalidAccountNumberException1 ia) {
			
			System.out.println("Account number does not exist.");
			
		}catch(InsufficientBalanceException1 ib) {
			
			System.out.println("Insufficient Balance.");
			
		}
		
	}

	
	
	

}
