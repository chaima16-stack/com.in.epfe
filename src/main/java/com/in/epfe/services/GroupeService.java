package com.in.epfe.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.in.epfe.entities.Groupe;

import com.in.epfe.repositories.GroupeRepository;

@Service
public class GroupeService implements IgroupeService {
	@Autowired
    GroupeRepository GroupeRepository;
	
	
	
	@Override
	public void ajouterGroupe(Groupe e) {
		// TODO Auto-generated method stub
		GroupeRepository.save(e);
		}

	@Override
	public void supprimerGroupe(Groupe e) {
		// TODO Auto-generated method stub
		GroupeRepository.delete(e);
	}

	@Override
	public void supprimerGroupeById(int id) {
		// TODO Auto-generated method stub
		GroupeRepository.deleteById((long) id);
	}

	@Override
	public List<Groupe> listeGroupes() {
		// TODO Auto-generated method stub
		List<Groupe> l= (List<Groupe>)GroupeRepository.findAll();
		
		return l;
	}
	@Override
	public Optional<Groupe> GroupeById(long id) {
		// TODO Auto-generated method stub
		Optional<Groupe> gp= GroupeRepository.findById( id);
		
		return gp;
	}
	
	

	@Override
	public void modifierGroupe(Groupe e) {
	
			
		
	}

}
