package com.ceaft.service;

import javax.ejb.Local;

import com.ceaf.exception.ResourceNotFoundException;
import com.ceaft.dto.AlumnoDTO;

@Local
public interface IStudentService {
	AlumnoDTO register(String id) throws ResourceNotFoundException;
}
