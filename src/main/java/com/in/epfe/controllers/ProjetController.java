package com.in.epfe.controllers;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.in.epfe.entities.Projet;
import com.in.epfe.entities.RequestEnvelope;
import com.in.epfe.entities.Societe;
import com.in.epfe.repositories.ProjetRepository;
import com.in.epfe.services.IprojetService;

@CrossOrigin(origins = "http://localhost:4200", allowedHeaders ="*" )
@Controller

public class ProjetController {
	@Autowired
	private IprojetService ProjetService;
	@Autowired
	private ProjetRepository ProjetRepository;
	
	@RequestMapping(value="/listProjet",method = RequestMethod.GET)
	@ResponseBody
	public List<Projet> Projets() {
		
		List<Projet> l= ProjetService.listesProjets();
		return l;
	}
	
	@RequestMapping("/Projet/{id}")
	@ResponseBody
	public ResponseEntity<Projet> getProjetById(@PathVariable("id") long id){
		Optional<Projet> p =ProjetService.ProjetById(id);
		if(p.isPresent()) {
			return new ResponseEntity<>(p.get(), HttpStatus.OK);
		}else {
			return new ResponseEntity<>( HttpStatus.NOT_FOUND);
		}
	}
	@PostMapping("/createProjet/{tech1}/{tech2}/{tech3}/{idetd}/{idbd}/{idmth}")
	@ResponseBody
	public ResponseEntity<Projet> createProjet(@RequestBody RequestEnvelope  req,@PathVariable("tech1") long tech1,@PathVariable("tech2") long tech2,@PathVariable("tech3") long tech3,@PathVariable("idetd") long idetd,@PathVariable("idbd") long idbd,@PathVariable("idmth") long idmth){
		try {
			Projet p=req.getProj();
			Societe soc=req.getSoc();
		ProjetService.ajouterProjet(p,tech1,tech2,tech3,idetd,idbd,idmth,soc);
		return new ResponseEntity<>(p, HttpStatus.CREATED);
		}catch(Exception e){
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		}
	@PutMapping("/updateProjet/{id}")
	@ResponseBody
	@Transactional
	public  void updateProjet(@PathVariable("id") long id, @RequestBody Projet p)
	{
		ProjetRepository.updateProjetById(p.getNom(),p.getCahier_charge(),p.getRapport(),p.getVideo(),p.getEncadrant_pro(),p.getAnnee(),p.getDuree(),p.getEnu(),p.getBinome(),
				id);
	}
	@DeleteMapping("/deleteProjet/{id}")
	@ResponseBody
	public ResponseEntity<HttpStatus> deleteProjet(@PathVariable("id") long id){
		try {
			ProjetService.supprimerProjetById((int) id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/createdepot")
	@ResponseBody
	@Transactional
	public  void depot(@RequestBody Projet p)
	{
		ProjetRepository.updateProjetById(p.getNom(),p.getCahier_charge(),p.getRapport(),p.getVideo(),p.getEncadrant_pro(),p.getAnnee(),p.getDuree(),p.getEnu(),p.getBinome(),
				p.getId());
	}
}
