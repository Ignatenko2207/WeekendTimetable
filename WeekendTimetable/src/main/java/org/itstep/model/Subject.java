package org.itstep.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table( name = "subjects")
public class Subject {

	private static Long DURATION = 100 * 60 * 90L; 
	
	@Id
	@GeneratedValue( strategy = GenerationType.AUTO)
	@Column( name = "subject_id")
	private Integer Id;
	@ManyToOne()
	private String name;

}
