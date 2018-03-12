package com.ceaft.dao;

import java.util.List;

import javax.ejb.Local;

import com.ceaft.model.Deuda;

@Local
public interface IAdeudoDAO {
	List<Deuda> obtenerDeudas(String id);
}
