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

import com.in.epfe.entities.Formation;
import com.in.epfe.repositories.FormationRepository;
import com.in.epfe.services.IformationService;
@CrossOrigin("*")
@Controller
public class FormationController {
	@Autowired
	private IformationService FormationService;
	@Autowired
	private FormationRepository FormationRepository;
	
	@RequestMapping(value="/listFormation",method = RequestMethod.GET)
	@ResponseBody
	public List<Formation> Formations() {
		
		List<Formation> l= FormationService.listesFormations();
		return l;
	}
	
	@RequestMapping("/Formation/{id}")
	@ResponseBody
	public ResponseEntity<Formation> getFormationById(@PathVariable("id") long id){
		Optional<Formation> gp =FormationService.FormationById(id);
		if(gp.isPresent()) {
			return new ResponseEntity<>(gp.get(), HttpStatus.OK);
		}else {
			return new ResponseEntity<>( HttpStatus.NOT_FOUND);
		}
	}
	@PostMapping("/createFormation")
	@ResponseBody
	public ResponseEntity<Formation> createFormation(@RequestBody Formation gp){
		try {
		FormationService.ajouterFormation(gp);
		return new ResponseEntity<>(gp, HttpStatus.CREATED);
		}catch(Exception e){
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		}
	@PutMapping("/updateFormation/{id}")
	@ResponseBody
	@Transactional
	public  void updateFormation(@PathVariable("id") long id, @RequestBody Formation gp)
	{
		FormationRepository.updateFormationById(gp.getNom(), id);
	}
	@DeleteMapping("/deleteFormation/{id}")
	@ResponseBody
	public ResponseEntity<HttpStatus> deleteFormation(@PathVariable("id") long id){
		try {
			FormationService.supprimerFormationById((int) id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
