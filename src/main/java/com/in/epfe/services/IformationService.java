package com.in.epfe.services;

import java.util.List;
import java.util.Optional;

import com.in.epfe.entities.Formation;

public interface IformationService {
public void ajouterFormation(Formation f);
	
	
	public void supprimerFormation(Formation f);
	public Optional<Formation> FormationById(long id);
	public void supprimerFormationById(int id);
	public void modifierFormation(Formation f);
	public List<Formation> listesFormations();
}
