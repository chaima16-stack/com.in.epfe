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
import javax.persistence.ManyToOne;
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
@Table(name="formation")
public class Formation implements Serializable {/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
public Formation() {
	super();
}
@Id
@Column(name="id_formation")
@GeneratedValue(strategy = GenerationType.IDENTITY)
long id;
@Column(name="nom_formation")
String nom;
@JsonIgnore
@OneToMany( cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "formation")
private List<Etudiant> etd= new ArrayList<>();
}
