package com.capgemini.service;

import com.capgemini.exception.InsufficientBalanceException1;
import com.capgemini.exception.InsufficientOpeningAmountException1;
import com.capgemini.exception.InvalidAccountNumberException1;



public interface Bank1 {
	
	String createAccount(int accountNumber, int amount) throws InsufficientOpeningAmountException1 ;
	int withdrawAmount(int accountNumber, int amount) throws InvalidAccountNumberException1, InsufficientBalanceException1;
	int depositAmount(int accountNumber, int amount) throws InvalidAccountNumberException1;
	int[] fundTransfer(int sender,int receiver, int amount) throws InvalidAccountNumberException1;

}
