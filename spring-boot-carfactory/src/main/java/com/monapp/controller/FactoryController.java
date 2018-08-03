package com.monapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.monapp.dao.FactoryDao;
import com.monapp.metier.Factory;

@RestController
@RequestMapping("/factory")
public class FactoryController {
	
	@Autowired
	FactoryDao factoryDao;
	
	@GetMapping("/")
	public ResponseEntity<List<Factory>> getFactory(){
		List<Factory> listFactorys = factoryDao.findAll();
		
		return new ResponseEntity<List<Factory>>(listFactorys, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Factory> getFactoryById(@PathVariable("id") int id){
		Factory factory = factoryDao.findByPrimaryKey(id);
		if (factory == null ) {
			return new ResponseEntity<Factory>(factory,HttpStatus.NOT_FOUND);
		} else {
		return new ResponseEntity<Factory>(factory, HttpStatus.NO_CONTENT);
	}
	}
	

	@PostMapping("/")
	public ResponseEntity <Factory> create(@RequestBody Factory factory){
		if(factory.getId() == 0) {
			factoryDao.save(factory);
			return new ResponseEntity<Factory>(factory, HttpStatus.CREATED);
		}else {
			return new ResponseEntity<>( HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("/")
	public ResponseEntity <Factory> maj(@RequestBody Factory factory){
		if(factory.getId() == 0) {
			factoryDao.save(factory);
			return new ResponseEntity<Factory>(factory, HttpStatus.CREATED);
		}else {
			factory = factoryDao.update(factory);
			return new ResponseEntity<Factory>(factory, HttpStatus.OK);
		}
	}

}
