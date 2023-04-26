package com.in.epfe.services;

import java.util.List;
import java.util.Optional;

import com.in.epfe.entities.Projet;
import com.in.epfe.entities.Societe;

public interface IprojetService {
public void ajouterProjet(Projet e,long idtech1,long idtech2,long idtech3,long idetd,long idbd,long idmth,Societe soc);
	
	
	public void supprimerProjet(Projet e);
	public Optional<Projet> ProjetById(long id);
	public void supprimerProjetById(int id);
	public void modifierProjet(Projet e);
	public List<Projet> listesProjets();
}
