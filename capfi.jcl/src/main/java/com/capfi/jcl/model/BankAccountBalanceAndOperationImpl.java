package com.capfi.jcl.model;

import java.math.BigDecimal;

public class BankAccountBalanceAndOperationImpl implements BankAccountBalanceAndOperation {
	protected BigDecimal balance =  BigDecimal.ZERO;

	public void doDeposit(BigDecimal mnt) throws FunctionalException {
		if( mnt.signum() < 0 )  throw new FunctionalException("Deposit must be positive value");
		balance = balance.add(mnt);
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void doWithdrawal(BigDecimal mnt) throws FunctionalException {
		if( mnt.signum() < 0 )  throw new FunctionalException("Withdrawal must be positive value");
		if( balance.subtract(mnt).signum() < 0)  throw new FunctionalException("Withdrawal can not exceed current balance: " + getBalance());
		balance = balance.subtract(mnt);
	}
}
