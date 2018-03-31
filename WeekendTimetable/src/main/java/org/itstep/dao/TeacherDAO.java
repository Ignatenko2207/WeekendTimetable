package org.itstep.dao;

import java.util.List;

import org.itstep.model.Subject;
import org.itstep.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherDAO extends JpaRepository<Teacher, String>{

	List<Teacher> findAllBySubject(Subject subject);
}
