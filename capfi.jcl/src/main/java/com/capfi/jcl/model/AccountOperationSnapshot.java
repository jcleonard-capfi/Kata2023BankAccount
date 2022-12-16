package com.capfi.jcl.model;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AccountOperationSnapshot extends AccountOperation {

	private BigDecimal balance;

	public AccountOperationSnapshot(OperationType operation, Date operationDate, BigDecimal amount, BigDecimal balance) {
		super(operation, amount, operationDate);
		this.balance = balance;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
		return "AccountOperation [operationDate=" + sdf.format(getOperationDate()) + ", operation=" + getOperation() + ", amount=" + getAmount()
				+ ", balance=" + balance + "]";
	}

}
