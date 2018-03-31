package org.itstep.dao;

import java.util.List;

import org.itstep.model.Group;
import org.itstep.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentDAO extends JpaRepository<Student, String> {

	List<Student> FindAllByGroup(Group group);
}
