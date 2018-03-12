package com.ceaft.dao;

import javax.ejb.Local;

import com.ceaf.exception.ResourceNotFoundException;
import com.ceaft.model.Alumno;

@Local
public interface IAlumnoDAO {
	Alumno buscarAlumno(String id) throws ResourceNotFoundException;
}
