package com.capfi.jcl.model;

import static org.junit.Assert.fail;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

import com.capfi.jcl.model.AccountOperation.OperationType;

public class AccountOperationTest {


	
	@Test
	public void createAccountOperation() {
		AccountOperation ao = new AccountOperation(OperationType.DEPOSITE, new BigDecimal("12345"));
		Assert.assertNotNull("AccountOperation must exist", ao);
	}

	@Test
	public void canLogAmount() {
		AccountOperation ao = new AccountOperation(OperationType.DEPOSITE, new BigDecimal("12345"));
		Assert.assertTrue("AccountOperation Log must show the amount.", ao.toString().contains("12345"));
	}

	
	@Test
	public void canReadOperationType() {
		AccountOperation ao = new AccountOperation(OperationType.DEPOSITE, new BigDecimal("12345"));
		Assert.assertTrue("AccountOperation Log must show the amount.", ao.getOperationType().toString().equalsIgnoreCase("deposite"));
	}
}
