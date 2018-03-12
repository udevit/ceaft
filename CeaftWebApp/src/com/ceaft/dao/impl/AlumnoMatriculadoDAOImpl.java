package com.ceaft.dao.impl;

import javax.ejb.Stateless;

import com.ceaf.exception.ResourceNotFoundException;
import com.ceaft.dao.IAlumnoMatriculadoDAO;
import com.ceaft.model.AlumnoMatriculado;
import com.ceaft.model.Curso;
import com.ceaft.model.Grupo;

@Stateless
public class AlumnoMatriculadoDAOImpl implements IAlumnoMatriculadoDAO{

	@Override
	public AlumnoMatriculado buscarAlumno(String id) throws ResourceNotFoundException {
		//TODO remover cuando se consulte a la BD
		AlumnoMatriculado a = new AlumnoMatriculado();
		a.setIdAlum(123345);
		a.setMatric("MAT0001");
		Grupo grupo = new Grupo();
		grupo.setHorario("09:00 - 14:00");
		grupo.setProf("Joe C Enriquez Fernandez");
		Curso curso = new Curso();
		curso.setNombre("Programación");
		grupo.setCurso(curso);
		a.setGrupo(grupo);
		return a;
	}
	
}
