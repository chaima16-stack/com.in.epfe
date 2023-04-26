package com.in.epfe.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
@Table(name="societe")
public class Societe implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
public Societe() {
	
}
@Id
@Column(name="id_soc")
@GeneratedValue(strategy = GenerationType.IDENTITY)
long id;
@Column(name="nom_soc")
String nom;
@Embedded
Adresse adresse;
@Column(name="adresse_mail")
String mail;
int tel;
@JsonIgnore
@OneToMany( cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "soc")
private List<Projet> proj=new ArrayList<>();
}
