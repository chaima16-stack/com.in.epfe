package com.in.epfe.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.in.epfe.entities.Groupe;
@Repository
public interface GroupeRepository extends JpaRepository<Groupe, Long>{
	@Modifying
	@Query("update Groupe p set p.nom = ?1 where p.id = ?2")
	void updateGroupeById(String nom, long id);
}
