package com.ceaft.dao.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.ceaf.exception.ResourceNotFoundException;
import com.ceaft.dao.IAlumnoDAO;
import com.ceaft.model.Alumno;

@Stateless
public class AlumnoDAOImpl implements IAlumnoDAO{

	@PersistenceContext(unitName="CeaftPU")
    private EntityManager entityManager;
	
	@Override
	public Alumno buscarAlumno(String id) throws ResourceNotFoundException {
		Query query = entityManager.createQuery("from Alumno a where a.matric = :matric");
		query.setParameter("matric", id);
		List<Alumno> list = query.getResultList();
		if(list.isEmpty()){
			throw new ResourceNotFoundException("Matrícula no registrada"); 
		}
		return list.get(0);
	}

}
