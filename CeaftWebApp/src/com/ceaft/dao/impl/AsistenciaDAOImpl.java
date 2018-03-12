package com.ceaft.dao.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.ejb.Stateless;

import com.ceaft.dao.IAsistenciaDAO;
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

}
