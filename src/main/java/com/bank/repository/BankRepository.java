package com.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bank.entity.Account;

@Repository
public interface BankRepository extends JpaRepository<Account, Integer> {
	
	Account findByAccno(Long accno);
	Account findByUsername(String username);


}
