package com.in.epfe.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.in.epfe.entities.Formation;
import com.in.epfe.entities.Formation;
import com.in.epfe.repositories.FormationRepository;

@Service
public class FormationService implements IformationService {
	@Autowired
     FormationRepository FormationRepository;
	
	
	
	@Override
	public void ajouterFormation(Formation e) {
		// TODO Auto-generated method stub
		FormationRepository.save(e);
		}

	@Override
	public void supprimerFormation(Formation e) {
		// TODO Auto-generated method stub
		FormationRepository.delete(e);
	}

	@Override
	public void supprimerFormationById(int id) {
		// TODO Auto-generated method stub
		FormationRepository.deleteById((long) id);
	}

	@Override
	public List<Formation> listesFormations() {
		// TODO Auto-generated method stub
		List<Formation> l= (List<Formation>)FormationRepository.findAll();
		
		return l;
	}

	@Override
	public void modifierFormation(Formation e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Optional<Formation> FormationById(long id) {
		// TODO Auto-generated method stub
		Optional<Formation> gp= FormationRepository.findById( id);
		
		return gp;
	}

}
