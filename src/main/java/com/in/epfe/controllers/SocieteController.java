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

import com.in.epfe.entities.Societe;
import com.in.epfe.repositories.SocieteRepository;
import com.in.epfe.services.IsocieteService;

@CrossOrigin("*")
@Controller
public class SocieteController {
	@Autowired
	private IsocieteService SocieteService;
	@Autowired
	private SocieteRepository SocieteRepository;
	
	@RequestMapping(value="/listSociete",method = RequestMethod.GET)
	@ResponseBody
	public List<Societe> Societes() {
		
		List<Societe> l= SocieteService.listesSocietes();
		return l;
	}
	
	@RequestMapping("/Societe/{id}")
	@ResponseBody
	public ResponseEntity<Societe> getSocieteById(@PathVariable("id") long id){
		Optional<Societe> soc =SocieteService.SocieteById(id);
		if(soc.isPresent()) {
			return new ResponseEntity<>(soc.get(), HttpStatus.OK);
		}else {
			return new ResponseEntity<>( HttpStatus.NOT_FOUND);
		}
	}
	@PostMapping("/createSociete")
	@ResponseBody
	public String createSociete(@RequestBody Societe soc){
		try {
		SocieteService.ajouterSociete(soc);
		return "e";
		}catch(Exception e){
			return e.getMessage();
		}
		}
	@PutMapping("/updateSociete/{id}")
	@ResponseBody
	@Transactional
	public  void updateSociete(@PathVariable("id") long id, @RequestBody Societe soc)
	{
		SocieteRepository.updateSocieteById(soc.getNom(),soc.getAdresse().getNum(),soc.getAdresse().getCodeP(),soc.getAdresse().getRue(),soc.getAdresse().getVille(),soc.getMail(),soc.getTel(), id);
	}
	@DeleteMapping("/deleteSociete/{id}")
	@ResponseBody
	public ResponseEntity<HttpStatus> deleteSociete(@PathVariable("id") long id){
		try {
			SocieteService.supprimerSocieteById((int) id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
