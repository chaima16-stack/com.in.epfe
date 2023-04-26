package com.in.epfe.services;

import java.util.List;
import java.util.Optional;

import com.in.epfe.entities.Methode_conception;


public interface Imethode_conceptionService {
public void ajouterMethode_conception(Methode_conception e);
	
	
	public void supprimerMethode_conception(Methode_conception e);
	public Optional<Methode_conception> Methode_conceptionById(long id);

	public void supprimerMethode_conceptionById(int id);
	public void modifierMethode_conception(Methode_conception e);
	public List<Methode_conception> listesMethode_conceptions();
}
