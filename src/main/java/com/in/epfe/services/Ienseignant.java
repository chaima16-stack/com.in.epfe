package com.in.epfe.services;

import java.util.List;
import java.util.Optional;

import com.in.epfe.entities.Enseignant;



public interface Ienseignant {
public void ajouterEnseignant(Enseignant e,long idtech1, long idtech2,long idtech3);
	
	
	public void supprimerenseignant(Enseignant e);
	public Optional<Enseignant> EnseignantById(long id);
	public void supprimerenseignantById(int id);
	public void modifierenseignant(Enseignant e);
	public List<Enseignant> listesEnsiegnants();
}
