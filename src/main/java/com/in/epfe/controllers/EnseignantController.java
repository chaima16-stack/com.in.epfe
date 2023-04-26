package com.in.epfe.controllers;


import java.util.ArrayList;
import java.util.List;

import java.util.Optional;

import javax.transaction.Transactional;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.in.epfe.entities.Email;
import com.in.epfe.entities.Enseignant;
import com.in.epfe.entities.Projet;
import com.in.epfe.entities.Technologie;
import com.in.epfe.repositories.EnseignantRepository;
import com.in.epfe.services.Ienseignant;
import com.in.epfe.services.IprojetService;
import com.in.epfe.repositories.ProjetRepository;

@CrossOrigin(origins = "http://localhost:4200", allowedHeaders ="*" )
@Controller
public class EnseignantController {
	
	@Autowired
	Ienseignant EnseignantService;
	@Autowired
	ProjetRepository ProjetRepository;
	@Autowired
	private EnseignantRepository EnseignantRepository;
	
	@RequestMapping(value="/listEnseignant",method = RequestMethod.GET)
	@ResponseBody
	public List<Enseignant> enseignants(Enseignant e, Model model) {
		
		List<Enseignant> l= EnseignantService.listesEnsiegnants();
		return l;
	}
	@RequestMapping("/Enseignant/{id}")
	@ResponseBody
	public ResponseEntity<Enseignant> getEnseignantById(@PathVariable("id") long id){
		Optional<Enseignant> ens =EnseignantService.EnseignantById(id);
		if(ens.isPresent()) {
			return new ResponseEntity<>(ens.get(), HttpStatus.OK);
		}else {
			return new ResponseEntity<>( HttpStatus.NOT_FOUND);
		}
	}
	@PostMapping("/createEnseignant/{id1}/{id2}/{id3}")
	@ResponseBody
	public ResponseEntity<Enseignant> createEnseignant(@RequestBody Enseignant ens,@PathVariable("id1") long id1,@PathVariable("id2") long id2,@PathVariable("id3") long id3){
		try {
		EnseignantService.ajouterEnseignant(ens,id1,id2,id3);
		return new ResponseEntity<>(ens, HttpStatus.CREATED);
		}catch(Exception e){
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		}
	
	@PutMapping("/updateEnseignant/{id}")
	@ResponseBody
	@Transactional
	public  void updateEnseignant(@PathVariable("id") long id, @RequestBody Enseignant ens)
	{
		EnseignantRepository.updateEnseignantById(ens.getNom(),ens.getPrenom(),ens.getMail(),ens.getMdp(),ens.getTel(),ens.getSpecialite(),id);
	}
	@DeleteMapping("/deleteEnseignant/{id}")
	@ResponseBody
	public ResponseEntity<HttpStatus> deleteEnseignant(@PathVariable("id") long id){
		try {
			EnseignantService.supprimerenseignantById((int) id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@RequestMapping(value="/listEnseignantTech/{idproj}",method = RequestMethod.GET)
	@ResponseBody
	public List<Enseignant> enseignants(@PathVariable("idproj") long idproj  ) {
		List<Enseignant> ll=new ArrayList<>();
	Projet p=ProjetRepository.findById(idproj).orElseThrow();
		List<Enseignant> l= EnseignantService.listesEnsiegnants();
		List<Technologie> tech= p.getTech();
		String tech1=tech.get(0).getNom();
		String tech2=tech.get(1).getNom();
		String tech3=tech.get(2).getNom();
		for(int i=1;i<l.size();i++) {
			if (l.get(i).getTech().get(0).getNom()==tech1 || l.get(i).getTech().get(0).getNom()==tech2 || l.get(i).getTech().get(0).getNom()==tech3 || l.get(i).getTech().get(1 ).getNom()==tech1 || l.get(i).getTech().get(1).getNom()==tech2 || l.get(i).getTech().get(1).getNom()==tech3 || l.get(i).getTech().get(2).getNom()==tech1 || l.get(i).getTech().get(2).getNom()==tech2 || l.get(i).getTech().get(2).getNom()==tech3 ) {
				ll.add(l.get(i));
			}
		}
				return ll;
	}

	

	
}
