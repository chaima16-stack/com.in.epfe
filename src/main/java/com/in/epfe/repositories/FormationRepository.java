package com.in.epfe.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.in.epfe.entities.Formation;
@Repository
public interface FormationRepository extends JpaRepository<Formation, Long> {
	@Modifying
	@Query("update Formation p set p.nom = ?1 where p.id = ?2")
	void updateFormationById(String nom, long id);
}
