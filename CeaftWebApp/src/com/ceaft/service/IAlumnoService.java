package com.ceaft.service;

import javax.ejb.Local;

import com.ceaf.exception.ResourceAlreadyExistsException;
import com.ceaf.exception.ResourceNotFoundException;
import com.ceaft.dto.AlumnoDTO;

@Local
public interface IAlumnoService {
	AlumnoDTO registrar(String id) throws ResourceNotFoundException, ResourceAlreadyExistsException;
	AlumnoDTO obtenerInformacion(String id) throws ResourceNotFoundException, ResourceAlreadyExistsException;
}
