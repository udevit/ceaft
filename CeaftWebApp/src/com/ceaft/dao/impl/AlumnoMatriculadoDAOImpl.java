package com.ceaft.dao.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.ceaf.exception.ResourceNotFoundException;
import com.ceaft.dao.IAlumnoMatriculadoDAO;
import com.ceaft.model.AlumnoMatriculado;

@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class AlumnoMatriculadoDAOImpl implements IAlumnoMatriculadoDAO{
	
	@PersistenceContext(unitName="CeaftPU")
    private EntityManager entityManager;
	
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public AlumnoMatriculado buscarAlumno(String id) throws ResourceNotFoundException {
		Query query = entityManager.createQuery("from AlumnoMatriculado a where a.matric = :matric");
		query.setParameter("matric", id);
		List<AlumnoMatriculado> list = query.getResultList();
		if(list.isEmpty()){
			throw new ResourceNotFoundException("Matrícula no registrada"); 
		}
		return list.get(0);
	}
	
}
