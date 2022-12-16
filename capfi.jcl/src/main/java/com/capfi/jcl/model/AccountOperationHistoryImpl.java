package com.capfi.jcl.model;

import java.util.ArrayList;
import java.util.List;

public class AccountOperationHistoryImpl implements AccountOperationHistory{	
	
	private List<AccountOperationSnapshot> accountOperationSnapshotList = new ArrayList<AccountOperationSnapshot>();

	@Override
	public void addOperation(AccountOperationSnapshot accountOperation) {
		accountOperationSnapshotList.add(accountOperation);
	}

	@Override
	public List<AccountOperationSnapshot> getAccountOperationList() {
		return accountOperationSnapshotList;
	}
	
}
