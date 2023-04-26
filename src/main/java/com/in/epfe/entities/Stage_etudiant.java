package com.in.epfe.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@FieldDefaults(level = AccessLevel.PRIVATE)

@Entity
@Table(name="stage_etudiant")
public class Stage_etudiant implements Serializable {/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
public Stage_etudiant() {
	
}
@EmbeddedId
private Stage_etudiant_PK stage_etudiant_PK;
String encadrant_pro;
int annee;
int duree;
@Column(name="enum")
String enu;
String binome;
@ManyToOne
@JoinColumn(name = "id_projet", referencedColumnName =
"id_proj", insertable = false , updatable = false)
private Projet projet;
@ManyToOne
@JoinColumn(name = "id_soc", referencedColumnName =
"id_soc", insertable = false , updatable = false)
private Societe soc;
}
