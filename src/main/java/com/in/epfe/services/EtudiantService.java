package com.in.epfe.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.in.epfe.entities.Etudiant;
import com.in.epfe.entities.Formation;
import com.in.epfe.entities.Groupe;
import com.in.epfe.repositories.EtudiantRepository;
import com.in.epfe.repositories.GroupeRepository;
import com.in.epfe.repositories.FormationRepository;
@Service
public class EtudiantService implements IetudiantService {
	@Autowired
     EtudiantRepository EtudiantRepository;
	@Autowired
	GroupeRepository GroupeRepository;
	@Autowired
	FormationRepository FormationRepository;
	
	
	@Override
	public void ajouterEtudiant(Etudiant e,long grpid, long forid) {
		// TODO Auto-generated method stub
		Groupe groupe=  GroupeRepository.findById(grpid).orElseThrow();
		e.setGrp(groupe);
		Formation f=  FormationRepository.findById(forid).orElseThrow();
		e.setFormation(f);
		EtudiantRepository.save(e);
		}

	@Override
	public void supprimerEtudiant(Etudiant e) {
		// TODO Auto-generated method stub
		EtudiantRepository.delete(e);
	}

	@Override
	public void supprimerEtudiantById(int id) {
		// TODO Auto-generated method stub
		EtudiantRepository.deleteById((long) id);
	}

	@Override
	public List<Etudiant> listesEtudiants() {
		// TODO Auto-generated method stub
		List<Etudiant> l= (List<Etudiant>)EtudiantRepository.findAll();
		
		return l;
	}

	@Override
	public void modifierEtudiant(Etudiant e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public Optional<Etudiant> EtudiantById(long id) {
		// TODO Auto-generated method stub
		Optional<Etudiant> etd= EtudiantRepository.findById( id);
		
		return etd;
	}



}
