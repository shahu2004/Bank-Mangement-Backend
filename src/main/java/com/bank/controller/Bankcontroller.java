package com.bank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bank.entity.Account;
import com.bank.entity.Transcation;
import com.bank.service.BankServiceImpl;

@RestController
@CrossOrigin("*")
public class Bankcontroller {
	@Autowired
	BankServiceImpl b;
	
	@PostMapping("/save")
	public Account create(@RequestBody Account A) {
		return b.createaccount(A);
		
	}
	@GetMapping("/account/{accno}")
	public Account getAccount(@PathVariable Long accno) {

	    return b.finddata(accno);
	}
	@GetMapping("/balance/{accno}")
	public Double getbalance(@PathVariable Long accno) {
		return b.checkbalance(accno);	
	}
	
	@PutMapping("/deposite/{accno}/{amount}")
	public Account depositemoney(@PathVariable Long accno,@PathVariable Double amount) {
		return b.deposit(accno, amount);
		
	}
	
	@PutMapping("/withdraw/{accno}/{amount}")
	public Account withdrawmoney(@PathVariable Long accno,@PathVariable Double amount) {
		
		return b.withdraw(accno, amount);
	}
	@GetMapping("/transaction/{accno}")
	public List<Transcation> gethistroy(@PathVariable Long accno) {
		return b.getTransactionHistory(accno);
		
	}
	@PutMapping("/upatecus/{accno}")
	public Account updateCustomer(@PathVariable Long accno, @RequestBody Account account) {
		return b.updateCustomer(accno, account);
		
		
	}
	
	 @PostMapping("/login")
	    public Account login(@RequestParam String username, @RequestParam String password) {

	        return b.login(username, password);
	    }
		
		
	
	

}
