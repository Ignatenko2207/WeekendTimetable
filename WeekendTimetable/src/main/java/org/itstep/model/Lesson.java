package org.itstep.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table( name = "lessons" )
public class Lesson {

	private static final Long DURATION = 1000 * 60 * 90L;
	
	@Id
	@GeneratedValue( strategy = GenerationType.AUTO)
	@Column( name = "lesson_id")
	private Integer id;
	
	@ManyToOne( targetEntity = Subject.class )
	private Subject subject;
	
	@ManyToOne( targetEntity = Teacher.class )
	private Teacher teacher;
	
	@ManyToOne( targetEntity = Group.class )
	private Group group;
	
	@Column( name = "cabinet")
	private String cabinet;
	
	@Column( name = "start_time")
	private Long startTime;
	
}
