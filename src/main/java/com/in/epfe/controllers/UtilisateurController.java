package com.in.epfe.controllers;



import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.in.epfe.entities.Enseignant;
import com.in.epfe.entities.Utilisateur;
import com.in.epfe.repositories.UtilisateurRepository;



@CrossOrigin(origins = "http://localhost:4200", allowedHeaders ="*" )
@Controller
public class UtilisateurController {

	
	@Autowired
	private UtilisateurRepository UtilisateurRepository;
	
	@RequestMapping("/login/{mail}/{mdp}")
	@ResponseBody
	@Transactional
	public  long login(@PathVariable("mail") String mail, @PathVariable("mdp") String mdp)
	{  
	  List<Utilisateur> l=UtilisateurRepository.loginByMailMdp(mail, mdp);
		if(l.isEmpty()) {
			return -1;
		}else {
			return l.get(0).getId();
		}
	}
	
	@RequestMapping("/cnx/{id}")
	@ResponseBody
	@Transactional
	public String cnx(@PathVariable("id") String id) {
		return   UtilisateurRepository.cnx(id);
		
				
	}
	
}
