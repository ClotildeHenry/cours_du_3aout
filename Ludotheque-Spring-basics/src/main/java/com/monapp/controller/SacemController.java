package com.monapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.monapp.dao.ArtisteDao;
import com.monapp.dao.SacemDao;
import com.monapp.metier.Artiste;
import com.monapp.metier.Sacem;

@Controller
@RequestMapping("/sacem")
public class SacemController {
	
	@Autowired
	SacemDao sacemDao;
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public String getAddNewArtistForm(Model model) {
		model.addAttribute("action","Ajouter");		

		Sacem s = new Sacem();
		
		model.addAttribute("sacem",s);
		return "sacem/addSacemRef";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String processAddNewArtistForm(@ModelAttribute("saccem") Sacem sacem) {
	
		if(sacem.getReference() == null) {
			sacemDao.save(sacem);			
		}else {
			sacemDao.update(sacem);
		}
		return "redirect:/artiste/list";
	}
	
	@RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
	public String getAddNewArtistForm(@PathVariable(value="id") int id, Model model) {
		model.addAttribute("action","Editer");		

		Sacem s = sacemDao.findByPrimaryKey(id);
		if(s == null) {
			return "redirect:/error";
		}
		model.addAttribute("sacem",s);
		return "sacem/addSacemRef";
	}
	
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public String getArtisteDetail(Model model, @PathVariable("id") int id) {
		Sacem s = sacemDao.findByPrimaryKey(id);
		
		model.addAttribute("artisteFromDb",s);
		return "artiste/showArtiste";
	}

	
	@RequestMapping(value="/list")
	public String listArtist(Model model) {		
		List<Sacem> listArt = sacemDao.findAll();
		model.addAttribute("listeSacems", listArt);
		return "artiste/listArtiste";
	}
	
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	public String deleteArtiste(Model model, @PathVariable("id") int id) {
		Sacem s = sacemDao.findByPrimaryKey(id);
		sacemDao.delete(s);
		
		return "redirect:/artiste/list";

	}
	
}
