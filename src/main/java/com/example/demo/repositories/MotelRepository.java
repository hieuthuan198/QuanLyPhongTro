package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;


import com.example.demo.entities.Motel;
import com.example.demo.entities.Motel1;

@Repository("motelRepository")
public interface MotelRepository extends CrudRepository<Motel, Integer>{
	
	@Query( "select new com.example.demo.entities.Motel1(name,price,address,email,describe,phoneNumber,image1,image2,image3,image4,type) from Motel ")
	public List<Motel1> findModel();
	//@Query( "select new com.example.demo.entities.Motel1(address,email) from Motel ")
	//public List<Motel1> findModel();
}
