package com.capfi.jcl.model;

import java.util.List;

public interface BankAccount extends BankAccountBalance, BankAccountOperation {

	public List<AccountOperationSnapshot> getAccountOperationList();
}
