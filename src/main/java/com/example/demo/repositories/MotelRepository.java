package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.example.demo.entities.Motel;
import com.example.demo.entities.Motel1;

@Repository("motelRepository")
public interface MotelRepository extends CrudRepository<Motel, Integer>{
	
	@Query( "select new com.example.demo.entities.Motel1(name,price,address,email,describe,phoneNumber,image1,image2,image3,image4,type) from Motel where Motel.status=1")
	public List<Motel1> findModel();
	
	@Query( "select new com.example.demo.entities.Motel1(m.name,m.price,m.address,m.email,m.describe,m.phoneNumber,m.image1,m.image2,m.image3,m.image4,m.type) from Motel as m join m.account a where a.username=:username")
	public List<Motel1> findModelByUsername(@Param("username") String username);
	//@Query( "select new com.example.demo.entities.Motel1(address,email) from Motel ")
	//public List<Motel1> findModel();
	
	@Query( "select new com.example.demo.entities.Motel1(m.name,m.price,m.address,m.email,m.describe,m.phoneNumber,m.image1,m.image2,m.image3,m.image4,m.type) from Motel as m where m.id=:id")
	public Motel1 findModel(@Param("id") int id);
	
	
	@Query( "select new com.example.demo.entities.Motel1(m.name,m.price,m.address,m.email,m.describe,m.phoneNumber,m.image1,m.image2,m.image3,m.image4,m.type) from Motel as m where m.address like %:address% and m.price like %:price%")
	public List<Motel1> search(@Param("address") String address, @Param("price") double price);
}
