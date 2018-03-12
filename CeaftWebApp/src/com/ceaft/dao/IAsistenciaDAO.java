package com.ceaft.dao;

import java.util.List;

import javax.ejb.Local;

import com.ceaft.dto.HistoricoPieDTO;
import com.ceaft.model.Asistencia;

@Local
public interface IAsistenciaDAO {
	List<Asistencia> obtenerAsistencias(String id);
	List<HistoricoPieDTO> obtenerHistoricoPie(String id);
}
