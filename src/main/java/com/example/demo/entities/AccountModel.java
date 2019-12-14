package com.example.demo.entities;

public class AccountModel {

	private Integer id;
	private String username;
	private String password;
	private String avatar;
	private String phoneNumber;
	private String email;
	private boolean status;
	
	
	
	public AccountModel() {
		super();
	}



	public AccountModel(String avatar, String phoneNumber, String email) {
		super();
		this.avatar = avatar;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}



	public AccountModel(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}



	public AccountModel(Integer id, String avatar, String phoneNumber, String email, boolean status) {
		super();
		this.id = id;
		this.avatar = avatar;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.status = status;
	}



	public AccountModel(Integer id, String username, String password, String avatar, String phoneNumber, String email,
			boolean status) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.avatar = avatar;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.status = status;
	}



	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getAvatar() {
		return avatar;
	}



	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}



	public String getPhoneNumber() {
		return phoneNumber;
	}



	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public boolean isStatus() {
		return status;
	}



	public void setStatus(boolean status) {
		this.status = status;
	}
	
	
	
}
