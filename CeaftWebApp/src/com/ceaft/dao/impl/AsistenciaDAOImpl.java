package com.ceaft.dao.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.ejb.Stateless;

import com.ceaft.dao.IAsistenciaDAO;
import com.ceaft.dto.HistoricoPieDTO;
import com.ceaft.model.Asistencia;

@Stateless
public class AsistenciaDAOImpl implements IAsistenciaDAO{

	@Override
	public List<Asistencia> obtenerAsistencias(String id) {
		//TODO remover cuando se consulte a la BD
		List<Asistencia> a = new ArrayList<>();
		a.add(new Asistencia("MAT0001", new Date()));
		a.add(new Asistencia("MAT0001", new GregorianCalendar(2018, Calendar.JANUARY, 1).getTime()));
		a.add(new Asistencia("MAT0001", new GregorianCalendar(2018, Calendar.JANUARY, 3).getTime()));
		a.add(new Asistencia("MAT0001", new GregorianCalendar(2018, Calendar.JANUARY, 5).getTime()));
		a.add(new Asistencia("MAT0001", new GregorianCalendar(2018, Calendar.JANUARY, 7).getTime()));
		a.add(new Asistencia("MAT0001", new GregorianCalendar(2018, Calendar.JANUARY, 9).getTime()));
		a.add(new Asistencia("MAT0001", new GregorianCalendar(2018, Calendar.FEBRUARY, 1).getTime()));
		a.add(new Asistencia("MAT0001", new GregorianCalendar(2018, Calendar.FEBRUARY, 3).getTime()));
		a.add(new Asistencia("MAT0001", new GregorianCalendar(2018, Calendar.FEBRUARY, 5).getTime()));
		a.add(new Asistencia("MAT0001", new GregorianCalendar(2018, Calendar.FEBRUARY, 7).getTime()));
		a.add(new Asistencia("MAT0001", new GregorianCalendar(2018, Calendar.MARCH, 1).getTime()));
		a.add(new Asistencia("MAT0001", new GregorianCalendar(2018, Calendar.MARCH, 3).getTime()));
		a.add(new Asistencia("MAT0001", new GregorianCalendar(2018, Calendar.MARCH, 5).getTime()));
		a.add(new Asistencia("MAT0001", new GregorianCalendar(2018, Calendar.MARCH, 7).getTime()));
		return a;
	}

	@Override
	public List<HistoricoPieDTO> obtenerHistoricoPie(String id) {
		//TODO remover cuando se consulte a la BD
		List<HistoricoPieDTO> historico = new ArrayList<>();
		historico.add(new HistoricoPieDTO("Lunes", 100));
		historico.add(new HistoricoPieDTO("Martes", 81));
		historico.add(new HistoricoPieDTO("Miércoles", 35));
		historico.add(new HistoricoPieDTO("Jueves", 70));
		historico.add(new HistoricoPieDTO("Viernes", 50));
		historico.add(new HistoricoPieDTO("Sábado", 45));
		historico.add(new HistoricoPieDTO("Domingo", 25));
		return historico;
	}

}
