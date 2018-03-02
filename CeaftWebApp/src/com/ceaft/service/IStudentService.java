package com.ceaft.service;

import javax.ejb.Local;

import com.ceaf.exception.ResourceNotFoundException;
import com.ceaft.dto.StudentDTO;

@Local
public interface IStudentService {
	StudentDTO register(Integer id) throws ResourceNotFoundException;
}
