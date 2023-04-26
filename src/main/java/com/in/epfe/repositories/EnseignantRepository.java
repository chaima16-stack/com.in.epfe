package com.in.epfe.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.in.epfe.entities.Enseignant;


@Repository
public interface EnseignantRepository extends JpaRepository<Enseignant, Long>  {

	
	@Modifying
	@Query("update Enseignant p set p.nom = ?1 , p.prenom= ?2 , p.mail= ?3 , p.mdp= ?4 , p.tel= ?5 , p.Specialite= ?6 where p.id = ?7 ")
	void updateEnseignantById(String nom,String prenom,String mail,String mdp,int tel,String spec,long id);
}
