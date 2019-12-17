package com.example.demo.entities;



public class Motel1 {
	
	private Integer id;
	private String name;
	private double price;
	private String address;
	private String email;
	private String describe;
	private String phoneNumber;
	private String image1;
	private String image2;
	private String image3;
	private String image4;
	private String type;
	private Account account;
	private boolean status;

	public Motel1() {
		super();
	}

	public Motel1(String address, String email) {
		super();
		this.address = address;
		this.email = email;
	}

	
	
	public Motel1(Integer id, String name, double price, String address, String email, String describe,
			String phoneNumber, String image1, String image2, String image3, String image4, String type) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.address = address;
		this.email = email;
		this.describe = describe;
		this.phoneNumber = phoneNumber;
		this.image1 = image1;
		this.image2 = image2;
		this.image3 = image3;
		this.image4 = image4;
		this.type = type;
	}

	public Motel1(Integer id, String name, double price, String address, String email, String describe,
			String phoneNumber, String image1, String image2, String image3, String image4, Account account,
			boolean status) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.address = address;
		this.email = email;
		this.describe = describe;
		this.phoneNumber = phoneNumber;
		this.image1 = image1;
		this.image2 = image2;
		this.image3 = image3;
		this.image4 = image4;
		this.account = account;
		this.status = status;
	}

	public Motel1(String name, double price, String address, String email, String describe, String phoneNumber,
			String image1, String image2, String image3, String image4, String type) {
		super();
		this.name = name;
		this.price = price;
		this.address = address;
		this.email = email;
		this.describe = describe;
		this.phoneNumber = phoneNumber;
		this.image1 = image1;
		this.image2 = image2;
		this.image3 = image3;
		this.image4 = image4;
		this.type = type;
	}

	public Motel1(Integer id, String name, double price, String address, String email, String describe,
			String phoneNumber, String image1, String image2, String image3, String image4, Account account,
			boolean status,String type) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.address = address;
		this.email = email;
		this.describe = describe;
		this.phoneNumber = phoneNumber;
		this.image1 = image1;
		this.image2 = image2;
		this.image3 = image3;
		this.image4 = image4;
		this.account = account;
		this.status = status;
		this.type=type;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getDescribe() {
		return describe;
	}


	public void setDescribe(String describe) {
		this.describe = describe;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public String getImage1() {
		return image1;
	}


	public void setImage1(String image1) {
		this.image1 = image1;
	}


	public String getImage2() {
		return image2;
	}


	public void setImage2(String image2) {
		this.image2 = image2;
	}


	public String getImage3() {
		return image3;
	}


	public void setImage3(String image3) {
		this.image3 = image3;
	}


	public String getImage4() {
		return image4;
	}


	public void setImage4(String image4) {
		this.image4 = image4;
	}


	public Account getAccount() {
		return account;
	}


	public void setAccount(Account account) {
		this.account = account;
	}


	public boolean isStatus() {
		return status;
	}


	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
	
	
}
