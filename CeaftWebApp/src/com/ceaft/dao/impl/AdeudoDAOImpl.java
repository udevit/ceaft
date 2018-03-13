package com.ceaft.dao.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.ceaft.dao.IAdeudoDAO;
import com.ceaft.model.Deuda;

@Stateless
public class AdeudoDAOImpl implements IAdeudoDAO{
	
	@PersistenceContext(unitName = "CeaftPersistenceUnit")
    private EntityManager entityManager;
	
	@Override
	public List<Deuda> obtenerDeudas(String id) {
		List<Deuda> deudas = new ArrayList<>();
		deudas.add(createDeudaObj(1234, new BigDecimal(500), Double.valueOf(500), Double.valueOf(500)));
		deudas.add(createDeudaObj(1234, new BigDecimal(100), Double.valueOf(15), Double.valueOf(100)));
		deudas.add(createDeudaObj(1234, new BigDecimal(300), Double.valueOf(250), Double.valueOf(300)));
		deudas.add(createDeudaObj(1234, new BigDecimal(250), Double.valueOf(100), Double.valueOf(250)));
		deudas.add(createDeudaObj(1234, new BigDecimal(800), Double.valueOf(120), Double.valueOf(800)));
		deudas.add(createDeudaObj(1234, new BigDecimal(100), Double.valueOf(80), Double.valueOf(100)));
		deudas.add(createDeudaObj(1234, new BigDecimal(100), Double.valueOf(25), Double.valueOf(50)));
		deudas.add(createDeudaObj(1234, new BigDecimal(145), Double.valueOf(100), Double.valueOf(50)));
		deudas.add(createDeudaObj(1234, new BigDecimal(23), Double.valueOf(5), Double.valueOf(23)));
		deudas.add(createDeudaObj(1234, new BigDecimal(28), Double.valueOf(10), Double.valueOf(28)));
		return deudas;
	}

	//TODO remover despues de conectar a la BD
	private Deuda createDeudaObj(long folio, BigDecimal adeudoTotal, 
		Double montoExtra, double montoRecuperado){
		Deuda deuda = new Deuda();
		deuda.setFolio(folio);
		deuda.setAdeudoTot(adeudoTotal);
		deuda.setMontoExtra(montoExtra);
		deuda.setMontoRecup(montoRecuperado);
		return deuda;
	}
	
}
