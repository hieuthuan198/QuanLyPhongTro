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

	@Override
	public List<Motel1> findModelByUsername(String username) {
		// TODO Auto-generated method stub
		return motelRepository.findModelByUsername(username);
	}

	/*@Override
	public Motel1 find(int id) {
		// TODO Auto-generated method stub
		return motelRepository.findModel().get(id);
	}

	*/

	@Override
	public List<Motel1> search(String address, double price) {
		// TODO Auto-generated method stub
		return motelRepository.search(address, price);
	}

	@Override
	public void delete(int id) {
		motelRepository.deleteById(id);
		
	}

	@Override
	public List<Motel1> searchPriceMoreThanFiveMillion(String address, double price) {
		// TODO Auto-generated method stub
		return motelRepository.searchPriceMoreThanFiveMillion(address, price);
	}

	@Override
	public List<Motel1> searchAddress(String address) {
		// TODO Auto-generated method stub
		return motelRepository.searchAdress(address);
	}

	
	

	



	

	
	

}
