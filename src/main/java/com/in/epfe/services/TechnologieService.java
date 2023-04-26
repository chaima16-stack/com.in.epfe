package com.in.epfe.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.in.epfe.entities.Technologie;

import com.in.epfe.repositories.TechnologieRepository;

@Service
public class TechnologieService implements ItechnologieService {
	@Autowired
     TechnologieRepository TechnologieRepository;
	
	
	
	@Override
	public void ajouterTechnologie(Technologie e) {
		// TODO Auto-generated method stub
		TechnologieRepository.save(e);
		}

	@Override
	public void supprimerTechnologie(Technologie e) {
		// TODO Auto-generated method stub
		TechnologieRepository.delete(e);
	}

	@Override
	public void supprimerTechnologieById(int id) {
		// TODO Auto-generated method stub
		TechnologieRepository.deleteById((long) id);
	}

	@Override
	public List<Technologie> listesTechnologies() {
		// TODO Auto-generated method stub
		List<Technologie> l= (List<Technologie>)TechnologieRepository.findAll();
		
		return l;
	}

	@Override
	public void modifierTechnologie(Technologie e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Optional<Technologie> TechnologieById(long id) {
		// TODO Auto-generated method stub
		Optional<Technologie> tech= TechnologieRepository.findById( id);
		
		return tech;
	}

}
