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

import com.in.epfe.entities.Technologie;
import com.in.epfe.repositories.TechnologieRepository;
import com.in.epfe.services.ItechnologieService;
@CrossOrigin("*")
@Controller
public class TechnologieController {
	@Autowired
	private ItechnologieService TechnologieService;
	@Autowired
	private TechnologieRepository TechnologieRepository;
	
	@RequestMapping(value="/listTechnologie",method = RequestMethod.GET)
	@ResponseBody
	public List<Technologie> Technologies() {
		
		List<Technologie> l= TechnologieService.listesTechnologies();
		return l;
	}
	
	@RequestMapping("/Technologie/{id}")
	@ResponseBody
	public ResponseEntity<Technologie> getTechnologieById(@PathVariable("id") long id){
		Optional<Technologie> gp =TechnologieService.TechnologieById(id);
		if(gp.isPresent()) {
			return new ResponseEntity<>(gp.get(), HttpStatus.OK);
		}else {
			return new ResponseEntity<>( HttpStatus.NOT_FOUND);
		}
	}
	@PostMapping("/createTechnologie")
	@ResponseBody
	public ResponseEntity<Technologie> createTechnologie(@RequestBody Technologie tech){
		try {
		TechnologieService.ajouterTechnologie(tech);
		return new ResponseEntity<>(tech, HttpStatus.CREATED);
		}catch(Exception e){
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		}
	@PutMapping("/updateTechnologie/{id}")
	@ResponseBody
	@Transactional
	public  void updateTechnologie(@PathVariable("id") long id, @RequestBody Technologie gp)
	{
		TechnologieRepository.updateTechnologieById(gp.getNom(), id);
	}
	@DeleteMapping("/deleteTechnologie/{id}")
	@ResponseBody
	public ResponseEntity<HttpStatus> deleteTechnologie(@PathVariable("id") long id){
		try {
			TechnologieService.supprimerTechnologieById((int) id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	
}
