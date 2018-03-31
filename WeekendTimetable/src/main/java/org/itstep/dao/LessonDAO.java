package org.itstep.dao;

import org.itstep.model.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LessonDAO extends JpaRepository<Lesson, Integer>{
	
}
