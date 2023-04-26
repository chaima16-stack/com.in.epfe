package com.in.epfe.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.in.epfe.entities.Base_donnees;
import com.in.epfe.entities.Etudiant;
import com.in.epfe.entities.Methode_conception;
import com.in.epfe.entities.Projet;
import com.in.epfe.entities.Societe;
import com.in.epfe.entities.Technologie;
import com.in.epfe.repositories.ProjetRepository;
import com.in.epfe.repositories.TechnologieRepository;
import com.in.epfe.repositories.EtudiantRepository;
import com.in.epfe.repositories.Methode_conceptionRepository;
import com.in.epfe.repositories.SocieteRepository;
import com.in.epfe.repositories.Base_donnesRepository;
@Service
public class ProjetService implements IprojetService {
	@Autowired
     ProjetRepository ProjetRepository;
	@Autowired
    TechnologieRepository technologieRepository;
	@Autowired
	EtudiantRepository etudiantRepository;
	@Autowired
	Methode_conceptionRepository Methode_conceptionRepository;
	@Autowired
	SocieteRepository SocieteRepository;
	@Autowired
	Base_donnesRepository Base_donnesRepository;
	@Autowired
	IsocieteService SocieteService;
	
	@Override
	public void ajouterProjet(Projet e,long idtech1,long idtech2,long idtech3,long idetd,long idbd,long idmth,Societe soc) {
		// TODO Auto-generated method stub
		Technologie tech1=technologieRepository.findById(idtech1).orElseThrow();
		Technologie tech2=technologieRepository.findById(idtech2).orElseThrow();
		Technologie tech3=technologieRepository.findById(idtech3).orElseThrow();
		
		e.getTech().add(tech1);
		e.getTech().add(tech2);
		e.getTech().add(tech3);
		
		tech1.getProj().add(e);
		tech2.getProj().add(e);
		tech3.getProj().add(e);
		
	///methode_conception
		
		Methode_conception mth=Methode_conceptionRepository.findById(idmth).orElseThrow();
		e.setMth(mth);
		///base de données
		Base_donnees bd=Base_donnesRepository.findById(idbd).orElseThrow();
		e.setBd(bd);
		///societe
		SocieteService.ajouterSociete(soc);
		long idsoc=SocieteRepository.getLastId();
		Societe socn=SocieteRepository.findById(idsoc).orElseThrow();
		e.setSoc(socn);
		
		
		
		ProjetRepository.save(e);
		///etudiant
		Etudiant etd=etudiantRepository.findById(idetd).orElseThrow();
		long idproj=ProjetRepository.getLastId();
		Projet proj =ProjetRepository.findById(idproj).orElseThrow();
		etd.setProj(proj);
		etudiantRepository.save(etd);
		}

	@Override
	public void supprimerProjet(Projet e) {
		// TODO Auto-generated method stub
		ProjetRepository.delete(e);
	}

	@Override
	public void supprimerProjetById(int id) {
		// TODO Auto-generated method stub
		ProjetRepository.deleteById((long) id);
	}

	@Override
	public List<Projet> listesProjets() {
		// TODO Auto-generated method stub
		List<Projet> l= (List<Projet>)ProjetRepository.findAll();
		
		return l;
	}

	@Override
	public void modifierProjet(Projet e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Optional<Projet> ProjetById(long id) {
		// TODO Auto-generated method stub
		Optional<Projet> p= ProjetRepository.findById( id);
		
		return p;
	}

}
