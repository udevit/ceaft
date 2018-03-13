package com.ceaft.dao.impl;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.ceaf.exception.ResourceNotFoundException;
import com.ceaft.dao.IAlumnoDAO;
import com.ceaft.model.Alumno;
import com.ceaft.model.Capacitacion;

@Stateless
public class AlumnoDAOImpl implements IAlumnoDAO{

	@PersistenceContext(unitName = "CeaftPersistenceUnit")
    private EntityManager entityManager;
	
	@Override
	public Alumno buscarAlumno(String id) throws ResourceNotFoundException {
		//TODO remover cuando se consulte a la BD
		Alumno alumno = new Alumno();
		alumno.setNom("Olegario Castellanos Guzman");
		alumno.setMatric("MAT0001");
		Capacitacion cap = new Capacitacion();
		cap.setNombre("Programación");
		alumno.setCapacitacion(cap);
		return alumno;
	}

}
