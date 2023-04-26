package com.in.epfe.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.in.epfe.entities.Technologie;
@Repository
public interface TechnologieRepository extends JpaRepository<Technologie, Long> {
	@Modifying
	@Query("update Technologie p set p.nom = ?1 where p.id = ?2")
	void updateTechnologieById(String nom, long id);
}
