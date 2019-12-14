package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Account;
import com.example.demo.entities.AccountModel;
import com.example.demo.repositories.AccountRepository;


@Service("accountService")
public class AccountService implements IAccountService {

	@Autowired
	private AccountRepository accountRepository;
	@Override
	public Account save(Account account) {
		// TODO Auto-generated method stub
		return accountRepository.save(account);
	}
	@Override
	public List<AccountModel> checkAccount(String username, String password) {
		// TODO Auto-generated method stub
		return accountRepository.checkAccount(username, password);
	}
	@Override
	public AccountModel login(String username, String password) {
		// TODO Auto-generated method stub
		return accountRepository.Login(username, password);
	}
	
	


}
