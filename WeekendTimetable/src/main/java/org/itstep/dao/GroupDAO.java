package org.itstep.dao;

import java.util.List;

import org.itstep.model.Group;

public interface GroupDAO {

	List<Group> findAllByCourse(String course);
}
