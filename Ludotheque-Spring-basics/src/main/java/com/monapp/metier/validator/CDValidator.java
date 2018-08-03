package com.monapp.metier.validator;

import java.util.Calendar;
import java.util.Date;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.monapp.metier.CD;

public class CDValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void validate(Object obj, Errors errors) {
		// TODO Auto-generated method stub
		 CD c = (CD) obj;
	        
	        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nombrePistes", "CD.addform.input.nbpistes.empty"); //cf le fichier properties
	        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nom", "CD.addform.input.CDname.empty");
	        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "anneeProduction", "CD.addform.input.annee.empty");
	        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "dateSortie", "CD.addform.input.dateSortie.empty");
	        
	          if (c.getNom() != null && c.getNom().length() < 3 ||
	                  c.getNom().length() > 20) {
	              errors.rejectValue("nom", "CD.addform.input.CDname.notvalid");
	          }
	          
	          if(c.getNombrePistes()!= 0 && c.getNombrePistes()<0 ||
	        		  c.getNombrePistes()>99) {
                  errors.rejectValue("nombrePistes", "CD.addform.input.nbpistes.notvalid");
	        	  
	          }
	          
	          if(c.getAnneeProduction()!=0 && c.getAnneeProduction()<= Calendar.getInstance().get(Calendar.YEAR)) {
	        	  errors.rejectValue("anneeProduction", "CD.addform.input.annee.notvalid");
	          }
	          
	          if(c.getDateSortie() != null && c.getDateSortie().before(new Date())) {
	        	  errors.rejectValue("dateSortie", "CD.addform.input.dateSortie.notvalid");
	          }
	          
	       
	       
	    }
	}

