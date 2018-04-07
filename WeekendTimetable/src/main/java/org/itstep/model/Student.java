package org.itstep.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Student {

	private String login;
	
	private String password;
	
	private String firstName;
	
	private String secondName;
	
	private UserRole role;
	
	private Group group;
}
