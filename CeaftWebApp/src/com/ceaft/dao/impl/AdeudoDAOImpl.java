package com.ceaft.dao.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.ceaft.dao.IAdeudoDAO;
import com.ceaft.model.Deuda;

@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class AdeudoDAOImpl implements IAdeudoDAO{
	
	@PersistenceContext(unitName="CeaftPU")
    private EntityManager entityManager;
	
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<Deuda> obtenerDeudas(String id) {
		Query query = entityManager.createQuery("from Deuda d where d.matric = :matric");
		query.setParameter("matric", id);
		List<Deuda> deudas = query.getResultList();
		return deudas;
	}
	
}
