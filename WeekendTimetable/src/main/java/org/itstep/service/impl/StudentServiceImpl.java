package org.itstep.service.impl;

import java.util.List;

import org.itstep.dao.StudentDAO;
import org.itstep.model.Group;
import org.itstep.model.Student;
import org.itstep.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired(required = false)
	StudentDAO studentDao;
	
	public Student save(Student student) {
		if(studentDao.getOne(student.getLogin()) == null) {
			return studentDao.save(student);
		}
		return null;
	}

	public Student update(Student student) {
		if(studentDao.getOne(student.getLogin()) != null) {
			return studentDao.save(student);
		}
		return null;
	}

	public Student get(String login) {
		return studentDao.getOne(login);
	}

	public List<Student> findAllByGroup(Group group) {
		return studentDao.findAllByGroup(group);
	}

	public void delete(String login) {
		studentDao.delete(login);
	}

}
