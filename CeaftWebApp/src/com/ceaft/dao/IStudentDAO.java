package com.ceaft.dao;

import javax.ejb.Local;

import com.ceaf.exception.ResourceNotFoundException;
import com.ceaft.model.Student;

@Local
public interface IStudentDAO {
	Student findStudent(Integer id) throws ResourceNotFoundException;
}
