package com.capfi.jcl.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.capfi.jcl.model.AccountOperation.OperationType;

public class AccountOperationHistoryTest {

	@Test
	public void createAccountOperationHistory() {
		AccountOperationHistory aoh = new AccountOperationHistoryImpl();
		Assert.assertNotNull("AccountOperationHistory must exist", aoh);
	}

	@Test
	public void canAccountOperationSnapshot() {
		// Preparation of Test
		AccountOperationHistory aoh = new AccountOperationHistoryImpl();

		// Test
		OperationType operation = OperationType.DEPOSITE;
		BigDecimal amount = new BigDecimal(100);
		Date date = new Date();
		BigDecimal balance = new BigDecimal(100);

		AccountOperationSnapshot aos = new AccountOperationSnapshot(operation, date, amount, balance); // new AccountOperation
		aoh.addOperation(aos);	

		List<AccountOperationSnapshot> list = aoh.getAccountOperationList();
		Assert.assertNotNull("History should not be Empty", list.size() > 0 );
	}

	@Test
	public void canRetrieveLastAccountOperationSnapshot() {
		// Preparation of Test
		AccountOperationHistory aoh = new AccountOperationHistoryImpl();


		OperationType operation = OperationType.DEPOSITE;
		BigDecimal amount = new BigDecimal(100);
		Date date = new Date();
		BigDecimal balance = new BigDecimal(100);

		AccountOperationSnapshot aos = new AccountOperationSnapshot(operation, date, amount, balance); // new AccountOperation
		aoh.addOperation(aos);
		
		// Test
		AccountOperationSnapshot lastOp = aoh.getAccountOperationList().get(0);
		Assert.assertNotNull("History should not be null", lastOp  );
		Assert.assertEquals("History amount  should be 100", lastOp.getAmount(), new BigDecimal(100)  );
		Assert.assertEquals("History balance should be 100", lastOp.getBalance(), new BigDecimal(100)  );
	}
	
	
	@Test
	public void canRetrieveLastAccountOperationSnapshotAfterDepositeAndWithDrawal() {
		// Preparation of Test
		AccountOperationHistory aoh = new AccountOperationHistoryImpl();

		// Deposite 100
		{ // Isolation des variables
			OperationType operation = OperationType.DEPOSITE;
			BigDecimal amount = new BigDecimal(100);
			Date date = new Date();
			BigDecimal balance = new BigDecimal(100);
	
			AccountOperationSnapshot aos = new AccountOperationSnapshot(operation, date, amount, balance); // new AccountOperation
			aoh.addOperation(aos);
		}
		
		// Withdrawal 05
		{ // Isolation des variables
			OperationType operation = OperationType.WITHDRAWAL;
			BigDecimal amount = new BigDecimal(05);
			Date date = new Date();
			BigDecimal balance = new BigDecimal(95);
	
			AccountOperationSnapshot aos = new AccountOperationSnapshot(operation, date, amount, balance); // new AccountOperation
			aoh.addOperation(aos);
		}
		
		// Test
		AccountOperationSnapshot lastOp = aoh.getAccountOperationList().get(aoh.getAccountOperationList().size()-1);
		Assert.assertNotNull("History should not be null", lastOp  );
		Assert.assertEquals("History amount  should be 5", lastOp.getAmount(), new BigDecimal(5)  );
		Assert.assertEquals("History balance should be 95", lastOp.getBalance(), new BigDecimal(95)  );
	}
	
	@Test
	public void canGenerateLogInfo() {
		// Preparation of Test
				AccountOperationHistory aoh = new AccountOperationHistoryImpl();


				OperationType operation = OperationType.DEPOSITE;
				BigDecimal amount = new BigDecimal(100);
				Date date = new Date();
				BigDecimal balance = new BigDecimal(100);

				AccountOperationSnapshot aos = new AccountOperationSnapshot(operation, date, amount, balance); // new AccountOperation
				aoh.addOperation(aos);
				
				// Test
				AccountOperationSnapshot lastOp = aoh.getAccountOperationList().get(0);

				Assert.assertTrue("History Info should contain amount in " + lastOp.toString() , lastOp.toString().contains("100") );

	}
}
