package com.bank.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.entity.Account;
import com.bank.entity.Transcation;
import com.bank.repository.BankRepository;

@Service
public class Bankservice implements BankServiceImpl{
	
	
	@Autowired
	BankRepository b;

	@Override
	public Account createaccount(Account A) {
	
		return b.save(A);
	}

	@Override
	public Account finddata(Long accno) {
	
		return b.findByAccno(accno);
	}

	@Override
	public Double checkbalance(long accno) {
		  Account a = b.findByAccno(accno);
		
		return a.getBalance();
	}

	@Override
	public Account deposit(Long accNo, Double amount) {
		Account a=b.findByAccno(accNo);
		a.setBalance(a.getBalance()+amount);
		Transcation t=new Transcation();
		t.setTraAmount(amount);
		t.setTraType("Deposite");
		t.setTraDate(LocalDate.now().toString());
		a.getTlist().add(t);
		return b.save(a);
	}

	@Override
	public Account withdraw(Long accNo, Double amount) {
		Account a=b.findByAccno(accNo);
		 if(a.getBalance() < amount) {
	            throw new RuntimeException("Insufficient Balance");
	        }
		a.setBalance(a.getBalance()-amount);
		a.setAccountType("withdraw");
		Transcation t=new Transcation();
		t.setTraAmount(amount);
		t.setTraType("Deposite");
		t.setTraDate(LocalDate.now().toString());
		a.getTlist().add(t);
		return b.save(a);
	}

	@Override
	public List<Transcation> getTransactionHistory(Long accNo) {
		Account a=b.findByAccno(accNo);
		return a.getTlist();
	}

	@Override
	public Account updateCustomer(Long accNo, Account account) {
		Account c=b.findByAccno(accNo);
		c.setAge(account.getAge());
		c.setName(account.getName());
		c.setGender(account.getGender());
		c.setAccountType(account.getAccountType());
		return b.save(c);
	}

	@Override
	public Account login(String username, String password) {
		 Account acc = b.findByUsername(username);

	        if(acc != null && acc.getPassword().equals(password)) {
	            return acc;
	        }

	        throw new RuntimeException("Invalid Credentials");
	}

	

	
	
	

}
