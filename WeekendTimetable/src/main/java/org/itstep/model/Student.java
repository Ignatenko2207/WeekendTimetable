package org.itstep.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table( name = "students")
public class Student {

	@Id
	@Column(name = "login")
	private String login;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "firstname")
	private String firstName;
	
	@Column(name = "secondname")
	private String secondName;
	
	@ManyToOne(targetEntity = Group.class)
	private Group group;
}
