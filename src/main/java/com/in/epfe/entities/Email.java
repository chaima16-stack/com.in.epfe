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
public class Email {

	    private long id;
	    private String name;
	    private String subject;
	    private String emailAddress;
	    private String message;
	public Email() {}
}
