package com.ceaft.dao.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TemporalType;

import com.ceaft.dao.IAsistenciaDAO;
import com.ceaft.dto.HistoricoPieDTO;
import com.ceaft.model.Asistencia;

@Stateless
public class AsistenciaDAOImpl implements IAsistenciaDAO{

	@PersistenceContext(unitName="CeaftPU")
    private EntityManager entityManager;
	
	@Override
	public List<Asistencia> obtenerAsistencias(String id) {
		Query query = entityManager.createQuery("from Asistencia a where a.matric = :matric");
		query.setParameter("matric", id);
		List<Asistencia> list = query.getResultList();
		return list;
	}

	@Override
	public List<HistoricoPieDTO> obtenerHistoricoPie(String id) {
		Query query = entityManager.createNativeQuery("select count(to_char(fecha, 'day')) as total, to_char(fecha, 'day') from asistencia group by to_char(fecha, 'day') order by to_char(fecha, 'day') asc");
		@SuppressWarnings("unchecked")
		List<Object[]> rawResultList = query.getResultList();
		List<HistoricoPieDTO> historico = new ArrayList<>();
		for (Object[] resultElement : rawResultList) {
			historico.add(new HistoricoPieDTO((String)resultElement[1], ((BigDecimal)resultElement[0]).longValue()));
		}
		return historico;
	}
	
	@Override
	public Asistencia obtenerAsistencia(String id) {
		Query query = entityManager.createQuery("from Asistencia a where a.matric = :matric and a.fecha = :fecha");
		query.setParameter("matric", id);
		query.setParameter("fecha", new Date(), TemporalType.DATE);
		List<Asistencia> list = query.getResultList();
		if(!list.isEmpty()){
			return list.get(0);
		}
		return null;
	}

	@Override
	public void registraAsistencia(Asistencia asistencia) {
		entityManager.persist(asistencia);
	}

}
