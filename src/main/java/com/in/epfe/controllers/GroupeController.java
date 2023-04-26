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

import com.in.epfe.entities.Groupe;
import com.in.epfe.repositories.GroupeRepository;
import com.in.epfe.services.IgroupeService;
@CrossOrigin("*")
@Controller
public class GroupeController {
	@Autowired
	private IgroupeService groupeService;
	@Autowired
	private GroupeRepository groupeRepository;
	
	@RequestMapping(value="/listGroupe",method = RequestMethod.GET)
	@ResponseBody
	public List<Groupe> Groupes() {
		
		List<Groupe> l= groupeService.listeGroupes();
		return l;
	}
	
	@RequestMapping("/groupe/{id}")
	@ResponseBody
	public ResponseEntity<Groupe> getGroupeById(@PathVariable("id") long id){
		Optional<Groupe> gp =groupeService.GroupeById(id);
		if(gp.isPresent()) {
			return new ResponseEntity<>(gp.get(), HttpStatus.OK);
		}else {
			return new ResponseEntity<>( HttpStatus.NOT_FOUND);
		}
	}
	@PostMapping("/creategroupe")
	@ResponseBody
	public ResponseEntity<Groupe> createGroupe(@RequestBody Groupe gp){
		try {
		groupeService.ajouterGroupe(gp);
		return new ResponseEntity<>(gp, HttpStatus.CREATED);
		}catch(Exception e){
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		}
	@PutMapping("/updategroupe/{id}")
	@ResponseBody
	@Transactional
	public  void updateGroupe(@PathVariable("id") long id, @RequestBody Groupe gp)
	{
		groupeRepository.updateGroupeById(gp.getNom(), id);
	}
	@DeleteMapping("/deletegroupe/{id}")
	@ResponseBody
	public ResponseEntity<HttpStatus> deleteGroupe(@PathVariable("id") long id){
		try {
			groupeService.supprimerGroupeById((int) id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
