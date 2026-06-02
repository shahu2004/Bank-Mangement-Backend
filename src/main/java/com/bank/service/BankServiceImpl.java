package com.bank.service;

import java.util.List;

import com.bank.entity.Account;
import com.bank.entity.Transcation;

public interface BankServiceImpl {
	
	public Account createaccount(Account A);
	
    public Account finddata(Long accno);
    
    public Double checkbalance(long accno);
    
    public Account deposit(Long accNo,Double amount);
    
    public Account withdraw(Long accNo,Double amount);

   public  List<Transcation> getTransactionHistory(Long accNo);
	
  public Account updateCustomer(Long accNo,Account account);
  
  Account login(String username,String password);

}
