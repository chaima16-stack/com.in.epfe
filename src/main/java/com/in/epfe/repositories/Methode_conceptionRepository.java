package com.in.epfe.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.in.epfe.entities.Methode_conception;
@Repository
public interface Methode_conceptionRepository extends JpaRepository<Methode_conception, Long> {
	@Modifying
	@Query("update Methode_conception p set p.nom = ?1 where p.id = ?2")
	void updateMethode_conceptionById(String nom, long id);
}
