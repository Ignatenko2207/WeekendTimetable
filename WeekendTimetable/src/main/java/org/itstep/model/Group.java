package org.itstep.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Group {

	private String name;
	
	private String course;
	
	private String specialization;
	
	public Group (String name,String course,String specialization)
	{
		this.name = name;
		this.course = course;
		this.specialization = specialization;
	}
}
