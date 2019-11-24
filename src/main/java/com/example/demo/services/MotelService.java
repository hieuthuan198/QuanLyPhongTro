package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Motel;
//import com.example.demo.entities.Motel;
import com.example.demo.entities.Motel1;
import com.example.demo.repositories.MotelRepository;

@Service("motelService")
public class MotelService implements IMotelService{

	@Autowired
	private MotelRepository motelRepository;

	@Override
	public List<Motel1> findAllMotel() {
		// TODO Auto-generated method stub
		return motelRepository.findModel();
	}

	@Override
	public Motel save(Motel motel) {
		// TODO Auto-generated method stub
		return motelRepository.save(motel);
	}



	

	
	

}
