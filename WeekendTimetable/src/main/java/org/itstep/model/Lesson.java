package org.itstep.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Lesson {

	private Integer id;
	
	private Subject subject;
	
	private Student teacher;
	
	private Group group;
	
	private String cabinet;
	
	private Long startTime;
	
	private static final Long DURATION = 1000*60*90L;
}
