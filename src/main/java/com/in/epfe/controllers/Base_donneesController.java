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

import com.in.epfe.entities.Base_donnees;
import com.in.epfe.repositories.Base_donnesRepository;
import com.in.epfe.services.Ibase_donnees;
@CrossOrigin("*")
@Controller
public class Base_donneesController {

	@Autowired
	private Ibase_donnees Base_donneesService;
	@Autowired
	private Base_donnesRepository Base_donneesRepository;
	
	@RequestMapping(value="/listBase_donnees",method = RequestMethod.GET)
	@ResponseBody
	public List<Base_donnees> Base_donneess() {
		
		List<Base_donnees> l= Base_donneesService.listesBase_donneess();
		return l;
	}
	
	@RequestMapping("/Base_donnees/{id}")
	@ResponseBody
	public ResponseEntity<Base_donnees> getBase_donneesById(@PathVariable("id") long id){
		Optional<Base_donnees> bd =Base_donneesService.Base_donneesById(id);
		if(bd.isPresent()) {
			return new ResponseEntity<>(bd.get(), HttpStatus.OK);
		}else {
			return new ResponseEntity<>( HttpStatus.NOT_FOUND);
		}
	}
	@PostMapping("/createBase_donnees")
	@ResponseBody
	public ResponseEntity<Base_donnees> createBase_donnees(@RequestBody Base_donnees bd){
		try {
		Base_donneesService.ajouterBase_donnees(bd);
		return new ResponseEntity<>(bd, HttpStatus.CREATED);
		}catch(Exception e){
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		}
	@PutMapping("/updateBase_donnees/{id}")
	@ResponseBody
	@Transactional
	public  void updateBase_donnees(@PathVariable("id") long id, @RequestBody Base_donnees bd)
	{
		Base_donneesRepository.updateBase_donneesById(bd.getNom(), id);
	}
	@DeleteMapping("/deleteBase_donnees/{id}")
	@ResponseBody
	public ResponseEntity<HttpStatus> deleteBase_donnees(@PathVariable("id") long id){
		try {
			Base_donneesService.supprimerBase_donneesById((int) id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	
}
