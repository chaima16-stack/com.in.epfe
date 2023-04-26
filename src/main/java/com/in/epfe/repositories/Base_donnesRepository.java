package com.in.epfe.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.in.epfe.entities.Base_donnees;
@Repository
public interface Base_donnesRepository extends JpaRepository<Base_donnees, Long>{
	@Modifying
	@Query("update Base_donnees p set p.nom = ?1 where p.id = ?2")
	void updateBase_donneesById(String nom, long id);
}
