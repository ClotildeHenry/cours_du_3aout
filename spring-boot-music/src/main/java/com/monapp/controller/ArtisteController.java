package com.monapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.monapp.dao.ArtisteDao;
import com.monapp.metier.Artiste;

@RestController
@RequestMapping("/artistes")
public class ArtisteController {
	
	@Autowired
	ArtisteDao artisteDao;
	
	@GetMapping("/")
	public ResponseEntity <List<Artiste>> getArtistes() {
		
		List<Artiste> listeArtistes = artisteDao.findAll();
		return new ResponseEntity<List<Artiste>>(listeArtistes, HttpStatus.OK);
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity <Artiste> getArtistesById(@PathVariable("id") int id){
		Artiste artiste = artisteDao.findByPrimaryKey(id);
		
		if(artiste == null) {
			return new ResponseEntity<Artiste>(artiste, HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Artiste>(artiste, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity <Artiste> deleteArtistesById(@PathVariable("id") int id){
		Artiste artiste = artisteDao.findByPrimaryKey(id);
		artisteDao.delete(artiste);
		
		if(artiste == null) {
			return new ResponseEntity<Artiste>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Artiste>(HttpStatus.NO_CONTENT);
	}

	@PostMapping("/")
	public ResponseEntity <Artiste> create(@RequestBody Artiste artiste){
		if(artiste.getId() == 0) {
			artisteDao.save(artiste);
			return new ResponseEntity<Artiste>(artiste, HttpStatus.CREATED);
		}else {
			return new ResponseEntity<>( HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("/")
	public ResponseEntity <Artiste> maj(@RequestBody Artiste artiste){
		if(artiste.getId() == 0) {
			artisteDao.save(artiste);
			return new ResponseEntity<Artiste>(artiste, HttpStatus.CREATED);
		}else {
			artiste = artisteDao.update(artiste);
			return new ResponseEntity<Artiste>(artiste, HttpStatus.OK);
		}
	}
}
