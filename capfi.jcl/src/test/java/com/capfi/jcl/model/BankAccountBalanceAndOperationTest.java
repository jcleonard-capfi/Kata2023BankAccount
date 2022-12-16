package com.capfi.jcl.model;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;


public class BankAccountBalanceAndOperationTest {

	@Test
	public void canCreateAccount() {
		BankAccountBalanceAndOperation ba = new BankAccountBalanceAndOperationImpl();
		Assert.assertNotNull("BankAccountBalanceAndOperation must exist",ba);
	}
	
	@Test
	public void canDoFirstDeposit100() throws FunctionalException {
		BankAccountBalanceAndOperation ba = new BankAccountBalanceAndOperationImpl();
		ba.doDeposit(new BigDecimal(100));
		Assert.assertEquals("After first Deposit of 100, balance should be 100", new BigDecimal(100) ,ba.getBalance());
	}
	
	@Test(expected = FunctionalException.class)
	public void canNotDoFirstDepositNegative100() throws FunctionalException {
		BankAccountBalanceAndOperation ba = new BankAccountBalanceAndOperationImpl();
		ba.doDeposit(new BigDecimal(-100));
	}
	
	@Test(expected = FunctionalException.class)
	public void canNotDoFirstWithdrawalNegative100() throws FunctionalException {
		BankAccountBalanceAndOperation ba = new BankAccountBalanceAndOperationImpl();
		ba.doDeposit(new BigDecimal(100));
		ba.doWithdrawal(new BigDecimal(-50));
	}
	
	
	@Test
	public void canDoAWithdrawal5() throws FunctionalException {
		// Init balance to 100
		BankAccountBalanceAndOperation ba = new BankAccountBalanceAndOperationImpl();
		ba.doDeposit(new BigDecimal(100));
		
		// Start of Test Withdrawal
		ba.doWithdrawal(new BigDecimal(5));
		
		// Balance should be 95 = 100 - 5
		Assert.assertEquals("After first Withdraw of 5, balance should be 95", new BigDecimal(95) ,ba.getBalance());
	}
	
	@Test(expected = FunctionalException.class)
	public void canNotDoAWithdrawal500() throws FunctionalException {
		// Init balance to 100
		BankAccountBalanceAndOperation ba = new BankAccountBalanceAndOperationImpl();
		ba.doDeposit(new BigDecimal(100));
		
		// Start of Test Withdrawal
		ba.doWithdrawal(new BigDecimal(500));
	}
}