package com.in.epfe.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.in.epfe.entities.Base_donnees;

import com.in.epfe.repositories.Base_donnesRepository;

@Service
public class Base_donneesService implements Ibase_donnees {
	@Autowired
     Base_donnesRepository Base_donneesRepository;
	
	
	
	@Override
	public void ajouterBase_donnees(Base_donnees e) {
		// TODO Auto-generated method stub
		Base_donneesRepository.save(e);
		}

	@Override
	public void supprimerBase_donnees(Base_donnees e) {
		// TODO Auto-generated method stub
		Base_donneesRepository.delete(e);
	}

	@Override
	public void supprimerBase_donneesById(int id) {
		// TODO Auto-generated method stub
		Base_donneesRepository.deleteById((long) id);
	}

	@Override
	public List<Base_donnees> listesBase_donneess() {
		// TODO Auto-generated method stub
		List<Base_donnees> l= (List<Base_donnees>)Base_donneesRepository.findAll();
		
		return l;
	}

	@Override
	public void modifierBase_donnees(Base_donnees e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Optional<Base_donnees> Base_donneesById(long id) {
		// TODO Auto-generated method stub
		Optional<Base_donnees> bd= Base_donneesRepository.findById( id);
		
		return bd;
	}



}
