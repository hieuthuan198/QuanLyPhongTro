package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Account;
import com.example.demo.entities.AccountModel;



@Repository("accountRepository")
public interface AccountRepository extends CrudRepository<Account, Integer>{
	@Query("select new com.example.demo.entities.AccountModel(username,password) from Account where username =:username and password=:password")
	public List<AccountModel> checkAccount(@Param("username") String username,@Param("password") String password);
}
