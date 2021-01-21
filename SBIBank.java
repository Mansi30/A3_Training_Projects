package com.capgemini.service;

import java.util.LinkedList;

import com.capgemini.bean.Account;
import com.capgemini.exception.InsufficientBalanceException;
import com.capgemini.exception.InsufficientOpeningAmountException;
import com.capgemini.exception.InvalidAccountNumberException;

public class SBIBank implements Bank{
	
	private LinkedList<Account> accounts = new LinkedList<>();

	@Override
	public String createAccount(int accountNumber, int amount) throws InsufficientOpeningAmountException {

		Account account = new Account();

		if (amount < 500)
		throw new InsufficientOpeningAmountException();
		account.setAccountNumber(accountNumber);
		account.setAmount(amount);
		accounts.add(account);
		return "Account created successfully!!!";
	}

	private Account searchAccount(int accountNumber) throws InvalidAccountNumberException {

		for (Account account : accounts) {

			
			if (accountNumber == account.getAccountNumber()) {
				return account;
			}
		}

		throw new InvalidAccountNumberException();
	}

	@Override
	public int withdrawAmount(int accountNumber, int amount)
			throws InvalidAccountNumberException, InsufficientBalanceException {

		Account account = searchAccount(accountNumber);

		if ((account.getAmount() - amount) >= 0) {
			account.setAmount(account.getAmount() - amount);

			return account.getAmount();
		}

		throw new InsufficientBalanceException();
	}

	@Override
	public int depositAmount(int accountNumber, int amount) throws InvalidAccountNumberException {
		Account account = searchAccount(accountNumber);
		account.setAmount(account.getAmount() + amount);
		return account.getAmount();

	}

	@Override
	public int[] fundTransfer(int senderAccount, int recieverAccount, int amount) throws InvalidAccountNumberException {

		Account sender = searchAccount(senderAccount);
		Account receiver = searchAccount(recieverAccount);
        sender.setAmount(sender.getAmount() - amount);
		receiver.setAmount(receiver.getAmount() + amount);
		int[] amt = { sender.getAmount(), receiver.getAmount() };

		return amt;

	}
	

}
