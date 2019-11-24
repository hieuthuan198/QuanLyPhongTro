package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Account;
import com.example.demo.entities.Motel;
import com.example.demo.entities.Motel1;
//import com.example.demo.entities.Motel;
//import com.example.demo.entities.Motel1;

import com.example.demo.services.MotelService;
//import com.example.demo.services.MotelService;

@RestController
@RequestMapping("api/motel")
public class UserRestController {

	@Autowired
	private MotelService motelService;
	
	//private BannerService bannerService;

	@RequestMapping(value = "findall", method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Motel1>> findAll() {
		try {
			return new ResponseEntity<List<Motel1>>(motelService.findAllMotel(),HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<Motel1>>(HttpStatus.BAD_REQUEST);
		}
	}
	@RequestMapping(value ="create",method = RequestMethod.POST,
			produces = MimeTypeUtils.APPLICATION_JSON_VALUE,
			consumes = MimeTypeUtils.APPLICATION_JSON_VALUE)
	
	public ResponseEntity<Motel> create(@RequestBody Motel motel){
		try {
			Account account=new Account();
			account.setId(1);
			motel.setAccount(account);
			motel=motelService.save(motel);
			return new ResponseEntity<Motel>(motel,HttpStatus.OK);
			
		} catch (Exception e) {
			
			return new ResponseEntity<Motel>(HttpStatus.BAD_REQUEST);
		
		}
	}
	
}