package com.capfi.jcl.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.capfi.jcl.model.AccountOperation.OperationType;

public class BankAccountImpl extends BankAccountBalanceAndOperationImpl implements BankAccount {
	AccountOperationHistory history = null;

	public BankAccountImpl() {
		this(new AccountOperationHistoryImpl());
	}
	
	public BankAccountImpl(AccountOperationHistory history) {
		super();
		this.history = history;
	}

	public void doDeposit(BigDecimal mnt) throws FunctionalException {
		super.doDeposit(mnt);
		Date operationDate = new Date();
		history.addOperation(new AccountOperationSnapshot(OperationType.DEPOSITE, operationDate , mnt , balance));
	}

	public void doWithdrawal(BigDecimal mnt) throws FunctionalException {
		super.doWithdrawal(mnt);
		
		Date operationDate = new Date();
		history.addOperation(new AccountOperationSnapshot(OperationType.WITHDRAWAL, operationDate , mnt , balance));
	}

	public List<AccountOperationSnapshot> getAccountOperationList() {
		return history.getAccountOperationList();
	}

}
