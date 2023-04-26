package com.in.epfe.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.in.epfe.entities.Enseignant;
import com.in.epfe.entities.Technologie;
import com.in.epfe.entities.Enseignant;
import com.in.epfe.repositories.EnseignantRepository;
import com.in.epfe.repositories.TechnologieRepository;

@Service
public class EnseignantService implements Ienseignant {
	@Autowired
     EnseignantRepository enseignantRepository;
	@Autowired
    TechnologieRepository technologieRepository;
	
	
	@Override
	public void ajouterEnseignant(Enseignant e,long idtech1, long idtech2,long idtech3) {
		// TODO Auto-generated method stub
		Technologie tech1=technologieRepository.findById(idtech1).orElseThrow();
		Technologie tech2=technologieRepository.findById(idtech2).orElseThrow();
		Technologie tech3=technologieRepository.findById(idtech3).orElseThrow();
		
		e.getTech().add(tech1);
		e.getTech().add(tech2);
		e.getTech().add(tech3);
		
		tech1.getEns().add(e);
		tech2.getEns().add(e);
		tech3.getEns().add(e);
		enseignantRepository.save(e);
		}

	@Override
	public void supprimerenseignant(Enseignant e) {
		// TODO Auto-generated method stub
		enseignantRepository.delete(e);
	}

	@Override
	public void supprimerenseignantById(int id) {
		// TODO Auto-generated method stub
		enseignantRepository.deleteById((long) id);
	}

	@Override
	public List<Enseignant> listesEnsiegnants() {
		// TODO Auto-generated method stub
		List<Enseignant> l= (List<Enseignant>)enseignantRepository.findAll();
		
		return l;
	}

	@Override
	public void modifierenseignant(Enseignant e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Optional<Enseignant> EnseignantById(long id) {
		// TODO Auto-generated method stub
		Optional<Enseignant> ens= enseignantRepository.findById( id);
		
		return ens;
	}

	
}
