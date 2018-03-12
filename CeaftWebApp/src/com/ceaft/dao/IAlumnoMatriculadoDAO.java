package com.ceaft.dao;

import javax.ejb.Local;

import com.ceaf.exception.ResourceNotFoundException;
import com.ceaft.model.AlumnoMatriculado;

@Local
public interface IAlumnoMatriculadoDAO {
	AlumnoMatriculado buscarAlumno(String id) throws ResourceNotFoundException;
}