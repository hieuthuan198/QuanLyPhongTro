package com.example.demo.services;



import java.util.List;

import com.example.demo.entities.Account;
import com.example.demo.entities.AccountModel;




public interface IAccountService {

	public Account save(Account account);
	
	public List<AccountModel> checkAccount(String username,String password);
}
