package com.in.epfe.services;

import java.util.List;
import java.util.Optional;

import com.in.epfe.entities.Etudiant;

public interface IetudiantService {
public void ajouterEtudiant(Etudiant e,long grpid,long forid);
	
	
	public void supprimerEtudiant(Etudiant e);
	public Optional<Etudiant> EtudiantById(long id);
	public void supprimerEtudiantById(int id);
	public void modifierEtudiant(Etudiant e);
	public List<Etudiant> listesEtudiants();
}
