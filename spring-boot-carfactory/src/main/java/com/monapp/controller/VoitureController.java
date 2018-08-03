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

import com.monapp.dao.VoitureDao;
import com.monapp.metier.Voiture;

@RestController
@RequestMapping("/cars")
public class VoitureController {
	
	@Autowired
	VoitureDao voitureDao;
	
	@GetMapping("/")
	public ResponseEntity<List<Voiture>> getVoiture(){
		List<Voiture> listVoitures = voitureDao.findAll();
		
		return new ResponseEntity<List<Voiture>>(listVoitures, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Voiture> getVoitureById(@PathVariable("id") int id){
		Voiture voiture = voitureDao.findByPrimaryKey(id);
		if (voiture == null ) {
			return new ResponseEntity<Voiture>(voiture,HttpStatus.NOT_FOUND);
		} else {
		return new ResponseEntity<Voiture>(voiture, HttpStatus.NO_CONTENT);
	}
	}
	

	@PostMapping("/")
	public ResponseEntity <Voiture> create(@RequestBody Voiture voiture){
		if(voiture.getId() == 0) {
			voitureDao.save(voiture);
			return new ResponseEntity<Voiture>(voiture, HttpStatus.CREATED);
		}else {
			return new ResponseEntity<>( HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("/")
	public ResponseEntity <Voiture> maj(@RequestBody Voiture voiture){
		if(voiture.getId() == 0) {
			voitureDao.save(voiture);
			return new ResponseEntity<Voiture>(voiture, HttpStatus.CREATED);
		}else {
			voiture = voitureDao.update(voiture);
			return new ResponseEntity<Voiture>(voiture, HttpStatus.OK);
		}
	}

}
