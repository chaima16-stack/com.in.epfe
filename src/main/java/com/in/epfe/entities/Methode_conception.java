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
@Table(name="methode_conception")
public class Methode_conception implements Serializable {/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
public Methode_conception() {
	
}
@Id
@Column(name="id_conc")
@GeneratedValue(strategy = GenerationType.IDENTITY)
long id;
@Column(name="nom_meth")
String nom;
@JsonIgnore
@OneToMany( cascade =CascadeType.ALL, orphanRemoval = true, mappedBy = "mth")

private List<Projet> proj=new ArrayList<>();
}
