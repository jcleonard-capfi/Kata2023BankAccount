package com.capfi.jcl.model;

import java.util.List;

public interface AccountOperationHistory {	
	
	void addOperation(AccountOperationSnapshot accountOperation);
	
	List<AccountOperationSnapshot> getAccountOperationList();
}

