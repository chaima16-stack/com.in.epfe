package com.in.epfe.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.in.epfe.entities.Etudiant;
@Repository
public interface EtudiantRepository extends JpaRepository<Etudiant, Long>{
	@Modifying
	@Query("update Etudiant p set p.nom = ?1 , p.prenom= ?2 , p.mail= ?3 , p.mdp= ?4 , p.tel= ?5  where p.id = ?6 ")
	void updateEtudiantById(String nom,String prenom,String mail,String mdp,int tel,long id);
}
