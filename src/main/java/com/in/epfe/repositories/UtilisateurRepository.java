package com.in.epfe.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;



import com.in.epfe.entities.Utilisateur;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, String>{

	@Query(value="SELECT * FROM  Users u WHERE u.mail_user= ?1 AND u.mdp_user= ?2 LIMIT 1",nativeQuery=true)
	List<Utilisateur> loginByMailMdp(String mail,String mdp);
	@Query(value="SELECT dtype FROM  Users u WHERE u.id_user= ?1  LIMIT 1",nativeQuery=true)
	String cnx(String id );
	@Query(value="SELECT * FROM  Users u WHERE u.mail_user= ?1  ",nativeQuery=true)
	List<Utilisateur> getUtilisateurByMail(String mail );
	
}
