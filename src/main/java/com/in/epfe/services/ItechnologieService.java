package com.in.epfe.services;

import java.util.List;
import java.util.Optional;


import com.in.epfe.entities.Technologie;

public interface ItechnologieService {
public void ajouterTechnologie(Technologie e);
	
	
	public void supprimerTechnologie(Technologie e);
	public Optional<Technologie> TechnologieById(long id);

	public void supprimerTechnologieById(int id);
	public void modifierTechnologie(Technologie e);
	public List<Technologie> listesTechnologies();
}
