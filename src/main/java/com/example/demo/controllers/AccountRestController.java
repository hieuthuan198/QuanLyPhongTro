package com.example.demo.controllers;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Account;
import com.example.demo.entities.AccountModel;
import com.example.demo.entities.Motel;
//import com.example.demo.entities.Motel;
//import com.example.demo.entities.Motel1;
import com.example.demo.services.AccountService;

//import com.example.demo.services.MotelService;

@RestController
@RequestMapping("api/account")
public class AccountRestController {

	@Autowired
	private AccountService accountService;
	
	//private BannerService bannerService;

	@RequestMapping(value ="create",method = RequestMethod.POST,
			produces = MimeTypeUtils.APPLICATION_JSON_VALUE,
			consumes = MimeTypeUtils.APPLICATION_JSON_VALUE)
	
	public ResponseEntity<Account> create(@RequestBody Account account){
		try {
			
			
			account=accountService.save(account);
			return new ResponseEntity<Account>(account,HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<Account>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "checkaccount/{username}/{password}", method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<AccountModel>> checkUsername(@PathVariable("username") String username,@PathVariable("password") String password){
		try {
			
			return new ResponseEntity<List<AccountModel>>(accountService.checkAccount(username, password), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<AccountModel>>(HttpStatus.BAD_REQUEST);
		}
		
	}
	@RequestMapping(value = "login/{username}/{password}", method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<AccountModel> login(@PathVariable("username") String username,@PathVariable("password") String password){
		try {
			
			return new ResponseEntity<AccountModel>(accountService.login(username, password), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<AccountModel>(HttpStatus.BAD_REQUEST);
		}
		
	}
	 @RequestMapping(value ="update",method = RequestMethod.PUT,
				produces = MimeTypeUtils.APPLICATION_JSON_VALUE,
				consumes = MimeTypeUtils.APPLICATION_JSON_VALUE)
		
		public ResponseEntity<Account> update(@RequestBody Account account){
			try {
				account=accountService.save(account);
				return new ResponseEntity<Account>(account,HttpStatus.OK);
				
			} catch (Exception e) {
				return new ResponseEntity<Account>(HttpStatus.BAD_REQUEST);
			}
		}
	
}
