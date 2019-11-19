package com.example.demo.entities;


import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;



@Entity
@Table(name = "account",uniqueConstraints = @UniqueConstraint(columnNames = "username"))
public class Account implements Serializable{
	

	
	private Integer id;
	private String username;
	private String password;
	private String avatar;
	private String phoneNumber;
	private String email;
	private boolean status;
	private Set<Motel> motels = new HashSet<Motel>(0);
	
	public Account() {
		super();
	}





	public Account(Integer id, String username, String password, String avatar, String phoneNumber, String email,
			boolean status, Set<Motel> motels) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.avatar = avatar;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.status = status;
		this.motels = motels;
	}





	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "username", unique = true, nullable = false, length = 250)
	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "password", length = 250)
	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}

	

	@Column(name = "phonenumber", length = 250)
	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Column(name = "email", length = 250)
	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "status", nullable = false)
	public boolean isStatus() {
		return status;
	}


	public void setStatus(boolean status) {
		this.status = status;
	}


	@OneToMany(fetch = FetchType.LAZY, mappedBy = "account")
	public Set<Motel> getMotels() {
		return motels;
	}


	
	public void setMotels(Set<Motel> motels) {
		this.motels = motels;
	}


	@Column(name = "avatar", length = 250)
	public String getAvatar() {
		return avatar;
	}



	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	

}
