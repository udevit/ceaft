package com.ceaft.dao.impl;

import javax.ejb.Stateless;

import com.ceaf.exception.ResourceNotFoundException;
import com.ceaft.dao.IStudentDAO;
import com.ceaft.model.Student;

@Stateless
public class StudentDAOImpl implements IStudentDAO{

	@Override
	public Student findStudent(Integer id) throws ResourceNotFoundException{
		return new Student();
	}

}
