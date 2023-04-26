package com.in.epfe.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.in.epfe.entities.Methode_conception;

import com.in.epfe.repositories.Methode_conceptionRepository;

@Service
public class Methode_conceptionService implements Imethode_conceptionService {
	@Autowired
     Methode_conceptionRepository Methode_conceptionRepository;
	
	
	
	@Override
	public void ajouterMethode_conception(Methode_conception e) {
		// TODO Auto-generated method stub
		Methode_conceptionRepository.save(e);
		}

	@Override
	public void supprimerMethode_conception(Methode_conception e) {
		// TODO Auto-generated method stub
		Methode_conceptionRepository.delete(e);
	}

	@Override
	public void supprimerMethode_conceptionById(int id) {
		// TODO Auto-generated method stub
		Methode_conceptionRepository.deleteById((long) id);
	}

	@Override
	public List<Methode_conception> listesMethode_conceptions() {
		// TODO Auto-generated method stub
		List<Methode_conception> l= (List<Methode_conception>)Methode_conceptionRepository.findAll();
		
		return l;
	}

	@Override
	public void modifierMethode_conception(Methode_conception e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Optional<Methode_conception> Methode_conceptionById(long id) {
		// TODO Auto-generated method stub
		Optional<Methode_conception> gp= Methode_conceptionRepository.findById( id);
		
		return gp;
	}



}
