package com.in.epfe.services;

import java.util.List;
import java.util.Optional;

import com.in.epfe.entities.Groupe;



public interface IgroupeService {
public void ajouterGroupe(Groupe e);
	
	
	public void supprimerGroupe(Groupe e);
	public Optional<Groupe> GroupeById(long id);
	public void supprimerGroupeById(int id);
	public void modifierGroupe(Groupe e);
	public List<Groupe> listeGroupes();
}
