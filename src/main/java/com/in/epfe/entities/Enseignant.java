package com.in.epfe.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
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
@Table(name="Enseignant")
@PrimaryKeyJoinColumn (name="id_user")
public class Enseignant extends Utilisateur{

	/**
	 * 
	 */
	
	
	private static final long serialVersionUID = 1L;

	public Enseignant() {
		
	}
	String Specialite;
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true,  mappedBy = "ens")
	private List<Projet> proj=new ArrayList<>();
	
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Technologie> tech=new ArrayList<>();
}
