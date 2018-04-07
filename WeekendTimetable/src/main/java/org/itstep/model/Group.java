package org.itstep.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table( name = "groups" )
public class Group {

	@Id
	@Column( name = "group_name")
	private String name;
	
	@Column( name = "course")
	private String course;
	
	@Column( name = "specialization")
	private String specialization;
	
}
