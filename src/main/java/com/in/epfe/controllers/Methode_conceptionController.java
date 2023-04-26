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

import com.in.epfe.entities.Methode_conception;
import com.in.epfe.services.Imethode_conceptionService;
import com.in.epfe.repositories.Methode_conceptionRepository;
@CrossOrigin("*")
@Controller
public class Methode_conceptionController {
	@Autowired
	private Imethode_conceptionService Methode_conceptionService;
	@Autowired
	private Methode_conceptionRepository Methode_conceptionRepository;
	
	@RequestMapping(value="/listMethode_conception",method = RequestMethod.GET)
	@ResponseBody
	public List<Methode_conception> Methode_conceptions() {
		
		List<Methode_conception> l= Methode_conceptionService.listesMethode_conceptions();
		return l;
	}
	
	@RequestMapping("/Methode_conception/{id}")
	@ResponseBody
	public ResponseEntity<Methode_conception> getMethode_conceptionById(@PathVariable("id") long id){
		Optional<Methode_conception> mth =Methode_conceptionService.Methode_conceptionById(id);
		if(mth.isPresent()) {
			return new ResponseEntity<>(mth.get(), HttpStatus.OK);
		}else {
			return new ResponseEntity<>( HttpStatus.NOT_FOUND);
		}
	}
	@PostMapping("/createMethode_conception")
	@ResponseBody
	public ResponseEntity<Methode_conception> createMethode_conception(@RequestBody Methode_conception mth){
		try {
		Methode_conceptionService.ajouterMethode_conception(mth);
		return new ResponseEntity<>(mth, HttpStatus.CREATED);
		}catch(Exception e){
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		}
	@PutMapping("/updateMethode_conception/{id}")
	@ResponseBody
	@Transactional
	public  void updateMethode_conception(@PathVariable("id") long id, @RequestBody Methode_conception mth)
	{
		Methode_conceptionRepository.updateMethode_conceptionById(mth.getNom(), id);
	}
	@DeleteMapping("/deleteMethode_conception/{id}")
	@ResponseBody
	public ResponseEntity<HttpStatus> deleteMethode_conception(@PathVariable("id") long id){
		try {
			Methode_conceptionService.supprimerMethode_conceptionById((int) id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
