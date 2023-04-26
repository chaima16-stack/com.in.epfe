package com.in.epfe.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.in.epfe.entities.Societe;
@Repository
public interface SocieteRepository extends JpaRepository<Societe, Long>{
	@Modifying
	@Query(value="update societe p set p.nom_soc = ?1 , p.num= ?2 , p.codep= ?3 , p.rue= ?4 , p.ville= ?5 , p.adresse_mail= ?6 , p.tel= ?7  where p.id_soc = ?8 ",nativeQuery=true)
	void updateSocieteById(String nom,int num, int codep, String rue, String ville, String mail, int tel, long id);
	@Query(value="select Max(p.id_soc) From societe p",nativeQuery=true)
	long getLastId();
}
