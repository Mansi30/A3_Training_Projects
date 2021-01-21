package com.capgemini.service;

import java.util.LinkedList;

import com.capgemini.bean.Account1;
import com.capgemini.exception.InsufficientBalanceException1;
import com.capgemini.exception.InsufficientOpeningAmountException1;
import com.capgemini.exception.InvalidAccountNumberException1;

public class SBIBank1 implements Bank1{
	
	private LinkedList<Account1> accounts = new LinkedList<>();

	@Override
	public String createAccount(int accountNumber, int amount) throws InsufficientOpeningAmountException1 {

		Account1 account = new Account1();

		if (amount < 500)
		throw new InsufficientOpeningAmountException1();
		account.setAccountNumber(accountNumber);
		account.setAmount(amount);
		accounts.add(account);
		return "Account created successfully!!!";
	}

	private Account1 searchAccount(int accountNumber) throws InvalidAccountNumberException1 {

		for (Account1 account : accounts) {

			
			if (accountNumber == account.getAccountNumber()) {
				return account;
			}
		}

		throw new InvalidAccountNumberException1();
	}

	@Override
	public int withdrawAmount(int accountNumber, int amount)
			throws InvalidAccountNumberException1, InsufficientBalanceException1 {

		Account1 account = searchAccount(accountNumber);
        synchronized (account) {
			
	
		if ((account.getAmount() - amount) >= 0) {
			account.setAmount(account.getAmount() - amount);

			return account.getAmount();
		}

		throw new InsufficientBalanceException1();
	  }
	}

	@Override
	public int depositAmount(int accountNumber, int amount) throws InvalidAccountNumberException1 {
		Account1 account = searchAccount(accountNumber);
		account.setAmount(account.getAmount() + amount);
		return account.getAmount();

	}

	@Override
	public int[] fundTransfer(int senderAccount, int recieverAccount, int amount) throws InvalidAccountNumberException1 {

		Account1 sender = searchAccount(senderAccount);
		Account1 receiver = searchAccount(recieverAccount);
        sender.setAmount(sender.getAmount() - amount);
		receiver.setAmount(receiver.getAmount() + amount);
		int[] amt = { sender.getAmount(), receiver.getAmount() };

		return amt;

	}
	

}
