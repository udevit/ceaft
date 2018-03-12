package com.ceaft.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.primefaces.model.chart.PieChartModel;

/**
 * 
 * @author Gary
 *
 */
public class AlumnoDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String nombre;
	private String nombreCurso;
	private String nombreProfesor;
	private String horario;
	private List<AsistenciaDTO> asistencia;
	private PieChartModel pieModel;

	/**
	 * 
	 */
	public AlumnoDTO(){
		
	}
	
	/**
	 * 
	 * @param id
	 * @param nombre
	 */
	public AlumnoDTO(String id, String nombre){
		this.id = id;
		this.nombre = nombre;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the nombreCurso
	 */
	public String getNombreCurso() {
		return nombreCurso;
	}

	/**
	 * @param nombreCurso the nombreCurso to set
	 */
	public void setNombreCurso(String nombreCurso) {
		this.nombreCurso = nombreCurso;
	}

	/**
	 * @return the nombreProfesor
	 */
	public String getNombreProfesor() {
		return nombreProfesor;
	}

	/**
	 * @param nombreProfesor the nombreProfesor to set
	 */
	public void setNombreProfesor(String nombreProfesor) {
		this.nombreProfesor = nombreProfesor;
	}

	/**
	 * @return the horario
	 */
	public String getHorario() {
		return horario;
	}

	/**
	 * @param horario the horario to set
	 */
	public void setHorario(String horario) {
		this.horario = horario;
	}

	/**
	 * @return the asistencia
	 */
	public List<AsistenciaDTO> getAsistencia() {
		if(asistencia == null){
			asistencia = new ArrayList<>();
		}
		return asistencia;
	}

	/**
	 * @param asistencia the asistencia to set
	 */
	public void setAsistencia(List<AsistenciaDTO> asistencia) {
		this.asistencia = asistencia;
	}

	/**
	 * @return the pieModel
	 */
	public PieChartModel getPieModel() {
		return pieModel;
	}

	/**
	 * @param pieModel the pieModel to set
	 */
	public void setPieModel(PieChartModel pieModel) {
		this.pieModel = pieModel;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (id != null ? id.hashCode() : 0);
		hash += (nombre != null ? nombre.hashCode() : 0);
		
		return hash;
	}

	@Override
	public boolean equals(Object e) {
		return false;
	}

	@Override
	public String toString() {
		return "AlumnoDTO[id=" + id + ", nombre= " + nombre + "]";
	}
	
}
