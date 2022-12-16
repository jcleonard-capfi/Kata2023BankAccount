package com.capfi.jcl.model;

import java.math.BigDecimal;

public interface BankAccountOperation {

	public void doDeposit(BigDecimal mnt) throws FunctionalException;

	public void doWithdrawal(BigDecimal mnt) throws FunctionalException;

}
