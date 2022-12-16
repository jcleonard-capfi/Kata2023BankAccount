package com.capfi.jcl.model;

import java.math.BigDecimal;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

import com.capfi.jcl.model.AccountOperation.OperationType;

public class BankAccountTest {

	@Test
	public void canCreateAccount() {
		BankAccount ba = new BankAccountImpl();
		Assert.assertNotNull("Account must exist", ba);
	}

	@Test
	public void canDoFirstDeposit100() throws FunctionalException {
		BankAccount ba = new BankAccountImpl();
		ba.doDeposit(new BigDecimal(100));
		Assert.assertEquals("After first Deposit of 100, balance should be 100", new BigDecimal(100), ba.getBalance());
	}

	@Test(expected = FunctionalException.class)
	public void canNotDoFirstDepositNegative100() throws FunctionalException {
		BankAccount ba = new BankAccountImpl();
		ba.doDeposit(new BigDecimal(-100));
	}

	@Test
	public void canDoAWithdrawal5() throws FunctionalException {
		// Init balance to 100
		BankAccount ba = new BankAccountImpl();
		ba.doDeposit(new BigDecimal(100));

		// Start of Test Withdrawal
		ba.doWithdrawal(new BigDecimal(5));

		// Balance should be 95 = 100 - 5
		Assert.assertEquals("After first Withdraw of 5, balance should be 95", new BigDecimal(95), ba.getBalance());

	}

	@Test(expected = FunctionalException.class)
	public void canNotDoAWithdrawal500() throws FunctionalException {
		// Init balance to 100
		BankAccount ba = new BankAccountImpl();
		ba.doDeposit(new BigDecimal(100));

		// Start of Test Withdrawal
		ba.doWithdrawal(new BigDecimal(500));
	}

	@Test
	public void canGenerateLogInfo() throws FunctionalException {
		// Init balance to 100
		BankAccount ba = new BankAccountImpl();
		ba.doDeposit(new BigDecimal(100));


		// Test
		Assert.assertEquals("History size should be 1" , ba.getAccountOperationList().size(), 1);

	}
}