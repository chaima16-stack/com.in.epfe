package com.in.epfe.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.in.epfe.entities.Projet;
@Repository
public interface ProjetRepository extends JpaRepository<Projet, Long>{
	@Modifying
	@Query("update Projet p set p.nom = ?1 , p.cahier_charge= ?2 , p.rapport= ?3 , p.video= ?4 , p.encadrant_pro= ?5 , p.annee= ?6, p.duree= ?7 , p.enu= ?8 , p.binome= ?9 where p.id = ?10 ")
	void updateProjetById(String nom,String c,String r,String mdp,String v,int an,int dur,String enu,String binome,long id);
	@Query(value="select Max(p.id_proj) From Projet_pfe p",nativeQuery=true)
	long getLastId();
}
