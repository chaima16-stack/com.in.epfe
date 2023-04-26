package com.in.epfe.entities;

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
public class RequestEnvelope {

	private Projet proj;
	private Societe soc;
	public RequestEnvelope() {
		
	}
}
