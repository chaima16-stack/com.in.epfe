package com.in.epfe.controllers;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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

import com.in.epfe.entities.Etudiant;
import com.in.epfe.entities.Projet;
import com.in.epfe.entities.Utilisateur;
import com.in.epfe.repositories.EtudiantRepository;
import com.in.epfe.services.IetudiantService;
import com.in.epfe.repositories.UtilisateurRepository;
import com.in.epfe.repositories.ProjetRepository;
@CrossOrigin("*")
@Controller 
public class EtudiantController {
	@Autowired
	private IetudiantService EtudiantService;
	@Autowired
	private EtudiantRepository EtudiantRepository;
	@Autowired
	private UtilisateurRepository UtilisateurRepository;
	@Autowired
	private ProjetRepository ProjetRepository;
	
	
	@RequestMapping(value="/listEtudiant",method = RequestMethod.GET)
	@ResponseBody
	public List<Etudiant> Etudiants() {
		
		List<Etudiant> l= EtudiantService.listesEtudiants();
		return l;
	}
	
	@RequestMapping("/Etudiant/{id}")
	@ResponseBody
	public ResponseEntity<Etudiant> getEtudiantById(@PathVariable("id") long id){
		Optional<Etudiant> etd =EtudiantService.EtudiantById(id);
		if(etd.isPresent()) {
			return new ResponseEntity<>(etd.get(), HttpStatus.OK);
		}else {
			return new ResponseEntity<>( HttpStatus.NOT_FOUND);
		}
	}
	@PostMapping("/createEtudiant/{grpid}/{forid}")
	@ResponseBody
	public ResponseEntity<Etudiant> createEtudiant(@RequestBody Etudiant etd,@PathVariable("grpid") long grpid,@PathVariable("forid") long forid){
		try {
		
		List<Utilisateur> l=UtilisateurRepository.getUtilisateurByMail(etd.getMail());
		if (l.isEmpty()) {
			EtudiantService.ajouterEtudiant(etd,grpid,forid);
			return new ResponseEntity<>(etd, HttpStatus.CREATED);
		}
		
		else return new ResponseEntity<>(null, HttpStatus.IM_USED);
		}catch(Exception e){
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		}
	@PutMapping("/updateEtudiant/{id}")
	@ResponseBody
	@Transactional
	public  void updateEtudiant(@PathVariable("id") long id, @RequestBody Etudiant etd)
	{
		EtudiantRepository.updateEtudiantById(etd.getNom(),etd.getPrenom(),etd.getMail(),etd.getMdp(),etd.getTel(),id);
	}
	@DeleteMapping("/deleteEtudiant/{id}")
	@ResponseBody
	public ResponseEntity<HttpStatus> deleteEtudiant(@PathVariable("id") long id){
		try {
			EtudiantService.supprimerEtudiantById((int) id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/addbinome/{id}")
	@ResponseBody
	@Transactional
	public  void depot(@RequestBody Projet p, @PathVariable("id") long id)
	{
		Etudiant etd= EtudiantRepository.findById(id).orElseThrow();
		Projet pp=ProjetRepository.findById(p.getId()).orElseThrow();
		pp.getEtd().add(etd);
		ProjetRepository.save(pp);
	}
}
