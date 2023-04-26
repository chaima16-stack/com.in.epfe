package com.in.epfe.entities;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class Stage_etudiant_PK implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private int id;
private int id_projet;
private int id_societe;

}
