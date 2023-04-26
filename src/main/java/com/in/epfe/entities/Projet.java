package com.in.epfe.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@FieldDefaults(level = AccessLevel.PRIVATE)

@Entity
@Table(name="Projet_pfe")
public class Projet implements Serializable {/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
public Projet() {
	
}
@Id
@Column(name="id_proj")
@GeneratedValue(strategy = GenerationType.IDENTITY)
long id;
@Column(name="nom_proj")
String nom;
String cahier_charge;
String rapport;
String video;
String encadrant_pro;
int annee;
int duree;
@Column(name="enum")
String enu;
String binome;
@JsonIgnore
@OneToMany( cascade =CascadeType.ALL, mappedBy = "proj")
private List<Etudiant> etd=new ArrayList<>();/////
@ManyToOne(cascade = CascadeType.ALL,fetch =FetchType.LAZY)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
private Enseignant ens;

@ManyToMany(cascade = CascadeType.ALL)
private List<Technologie> tech=new ArrayList<>();////
@ManyToOne(cascade = CascadeType.ALL, fetch =FetchType.LAZY)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
private Societe soc;///
@ManyToOne(cascade = CascadeType.ALL, fetch =FetchType.LAZY)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
private Base_donnees bd;///
@ManyToOne(cascade = CascadeType.ALL, fetch =FetchType.LAZY)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
private Methode_conception mth;///
}
