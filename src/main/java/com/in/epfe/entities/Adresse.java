package com.in.epfe.entities;

import java.util.Set;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Embeddable
public class Adresse {

	public Adresse() {
		// TODO Auto-generated constructor stub
	}

	int num;
	
	String rue;
	
	String ville;
	
	int codeP;
	
}
