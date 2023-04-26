package com.in.epfe.entities;


import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
@Table(name="Etudiant")
@PrimaryKeyJoinColumn (name="id_user")
public class Etudiant extends Utilisateur{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public Etudiant() {
		
	}
	String releve1ere;
	String releve2eme;
@ManyToOne(cascade = CascadeType.ALL,fetch =FetchType.LAZY)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
private Groupe grp;
@ManyToOne(cascade = CascadeType.ALL,fetch =FetchType.LAZY)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
private Formation formation;
@ManyToOne(cascade = CascadeType.ALL,fetch =FetchType.LAZY)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
private Projet proj;
}
