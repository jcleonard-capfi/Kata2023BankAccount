package com.capfi.jcl.model;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AccountOperation {
	public enum OperationType {
		DEPOSITE, WITHDRAWAL
	}

	private OperationType operation;
	private BigDecimal amount;
	private Date operationDate;

	public Date getOperationDate() {
		return operationDate;
	}

	public AccountOperation(OperationType operation, BigDecimal amount) {
		this(operation, amount, new Date());
	}

	public AccountOperation(OperationType operation, BigDecimal amount, Date operationDate) {
		this.operation = operation;
		this.amount = amount;
		this.operationDate = operationDate;
	}

	public OperationType getOperationType() {
		return operation;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public OperationType getOperation() {
		return operation;
	}

	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
		return "AccountOperation [operationDate=" + sdf.format(operationDate) + ", operation=" + operation + ", amount=" + amount + "]";
	}
}
