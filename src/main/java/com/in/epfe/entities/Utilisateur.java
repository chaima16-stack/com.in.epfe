package com.in.epfe.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;



@Getter
@Setter
//@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name="Users")
public class Utilisateur implements Serializable{

	
	private static final long serialVersionUID = 1L;

	public Utilisateur() {
		
		// TODO Auto-generated constructor stub
	}
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  @Column(name="id_user")
 long id;
  @Column(name="nom_user")
  String nom;
  @Column(name="prenom_user")
  String prenom;
  @Column(name="mail_user")
  String mail;
  @Column(name="mdp_user")
  String mdp;
  @Column(name="tel_user")
  int tel;
}
