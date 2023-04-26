package com.in.epfe.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.in.epfe.entities.Societe;
import com.in.epfe.repositories.SocieteRepository;

@Service
public class SocieteService implements IsocieteService {
	@Autowired
     SocieteRepository SocieteRepository;
	
	
	
	@Override
	public void ajouterSociete(Societe e) {
		// TODO Auto-generated method stub
		SocieteRepository.save(e);
		}

	@Override
	public void supprimerSociete(Societe e) {
		// TODO Auto-generated method stub
		SocieteRepository.delete(e);
	}

	@Override
	public void supprimerSocieteById(int id) {
		// TODO Auto-generated method stub
		SocieteRepository.deleteById((long) id);
	}

	@Override
	public List<Societe> listesSocietes() {
		// TODO Auto-generated method stub
		List<Societe> l= (List<Societe>)SocieteRepository.findAll();
		
		return l;
	}

	@Override
	public void modifierSociete(Societe e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Optional<Societe> SocieteById(long id) {
		// TODO Auto-generated method stub
		Optional<Societe> soc= SocieteRepository.findById( id);
		
		return soc;
	}


}
