package com.ceaft.dao.impl;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.ceaf.exception.ResourceNotFoundException;
import com.ceaft.dao.IAlumnoMatriculadoDAO;
import com.ceaft.model.AlumnoMatriculado;
import com.ceaft.model.Curso;
import com.ceaft.model.Grupo;

@Stateless
public class AlumnoMatriculadoDAOImpl implements IAlumnoMatriculadoDAO{
	
	@PersistenceContext(unitName = "CeaftPersistenceUnit")
    private EntityManager entityManager;
	
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
		curso.setDiasClase("Lunes - Viernes");
		grupo.setCurso(curso);
		a.setGrupo(grupo);
		return a;
	}
	
}
