package com.example.demo.services;



import java.util.List;

import com.example.demo.entities.Motel;
import com.example.demo.entities.Motel1;

public interface IMotelService {
 public List<Motel1> findAllMotel();
 
 public Motel save(Motel motel);
}