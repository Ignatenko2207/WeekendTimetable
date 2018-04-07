package org.itstep.service.impl;

import java.util.List;

import org.itstep.dao.TeacherDAO;
import org.itstep.model.Subject;
import org.itstep.model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;

public class TeacherServiceImpl {
	
	@Autowired
	TeacherDAO TeacherDao;
	
	public Teacher save(Teacher teacher)
	{
		if(TeacherDao.getOne(teacher.getLogin()) == null) {
			return TeacherDao.save(teacher);
		}
		return null;
	}
	
	public Teacher upadate(Teacher teacher) 
	{
		if(TeacherDao.getOne(teacher.getLogin()) == null) {
			return TeacherDao.save(teacher);
		}
		return null;
	}
	
	public Teacher get(String login)
	{
		return TeacherDao.getOne(login);
	}
	
	public List<Teacher> findAllBySubject(Subject subject){
		return TeacherDao.findAllBySubject(subject);
	}
	
	public void delete(String login) {
		TeacherDao.delete(login);
	}
}
