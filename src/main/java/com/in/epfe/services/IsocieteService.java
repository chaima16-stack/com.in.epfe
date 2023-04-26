package com.in.epfe.services;

import java.util.List;
import java.util.Optional;

import com.in.epfe.entities.Societe;

public interface IsocieteService {
public void ajouterSociete(Societe e);
	
	
	public void supprimerSociete(Societe e);
	public Optional<Societe> SocieteById(long id);
	public void supprimerSocieteById(int id);
	public void modifierSociete(Societe e);
	public List<Societe> listesSocietes();
}
