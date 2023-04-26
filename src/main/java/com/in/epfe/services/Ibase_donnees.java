package com.in.epfe.services;

import java.util.List;
import java.util.Optional;

import com.in.epfe.entities.Base_donnees;


public interface Ibase_donnees {
public void ajouterBase_donnees(Base_donnees e);
	
	
	public void supprimerBase_donnees(Base_donnees e);
	public Optional<Base_donnees> Base_donneesById(long id);

	public void supprimerBase_donneesById(int id);
	public void modifierBase_donnees(Base_donnees e);
	public List<Base_donnees> listesBase_donneess();
}
