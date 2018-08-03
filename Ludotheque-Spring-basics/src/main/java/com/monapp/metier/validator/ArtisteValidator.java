package com.monapp.metier.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.monapp.metier.Artiste;

public class ArtisteValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void validate(Object obj, Errors errors) {
		// TODO Auto-generated method stub

	        Artiste a = (Artiste) obj;
	        
	        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "prenom", "artiste.addform.input.firstname.empty"); //cf le fichier properties
	        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nom", "artiste.addform.input.firstname.empty");
	        
	          if (a.getNom() != null && a.getNom().length() < 3 ||
	                  a.getNom().length() > 24) {
	              errors.rejectValue("prenom", "artiste.addform.input.firstname.notvalid");
	          }
	          
	          if (a.getPrenom() != null && a.getPrenom().length() < 3 ||
	                  a.getPrenom().length() > 24) {
	                   errors.rejectValue("nom", "artiste.addform.input.lastname.notvalid");
	          }
	        
	    }
}
