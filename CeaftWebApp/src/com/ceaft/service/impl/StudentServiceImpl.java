package com.ceaft.service.impl;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.ceaf.exception.ResourceNotFoundException;
import com.ceaft.dao.IStudentDAO;
import com.ceaft.dto.StudentDTO;
import com.ceaft.model.Student;
import com.ceaft.service.IStudentService;

@Stateless
public class StudentServiceImpl implements IStudentService{

	@EJB
	private IStudentDAO iStudentDAO;
	
	@Override
	public StudentDTO register(String id) throws ResourceNotFoundException {
		try{
			Student student = iStudentDAO.findStudent(id);
			if(student != null){
				return new StudentDTO(student.getId(), student.getName());
			}else{
				throw new ResourceNotFoundException("<< Estudiante no encontrado >>");
			}
		}catch(Exception e){
			throw e;
		}
	}

}
