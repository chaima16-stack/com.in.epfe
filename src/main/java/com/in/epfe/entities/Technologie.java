package com.in.epfe.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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
@Table(name="technologie")
public class Technologie implements Serializable {/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
public Technologie() {
	
}
@Id
@Column(name="id_tech")
@GeneratedValue(strategy = GenerationType.IDENTITY)
long id;
@Column(name="nom_tech")
String nom;
@JsonIgnore
@ManyToMany( cascade = CascadeType.ALL, mappedBy = "tech")
private List<Projet> proj=new ArrayList<>();
@JsonIgnore
@ManyToMany( cascade = CascadeType.ALL, mappedBy = "tech")
private List<Enseignant> ens=new ArrayList<>();

}
