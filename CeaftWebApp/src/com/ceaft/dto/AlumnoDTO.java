package com.ceaft.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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
	private String photoName;
	private String nombre;
	private String nombreCurso;
	private String nombreProfesor;
	private String horario;
	private String diasClase;
	private List<AsistenciaDTO> asistencia;
	private List<DeudaDTO> deuda;
	private List<HistoricoPieDTO> historicoPieData;

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
	 * @return the photoName
	 */
	public String getPhotoName() {
		return photoName;
	}

	/**
	 * @param photoName the photoName to set
	 */
	public void setPhotoName(String photoName) {
		this.photoName = photoName;
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
	 * @return the diasClase
	 */
	public String getDiasClase() {
		return diasClase;
	}

	/**
	 * @param diasClase the diasClase to set
	 */
	public void setDiasClase(String diasClase) {
		this.diasClase = diasClase;
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
	 * @return the deuda
	 */
	public List<DeudaDTO> getDeuda() {
		if(deuda == null){
			deuda = new ArrayList<>();
		}
		return deuda;
	}

	/**
	 * @param deuda the deuda to set
	 */
	public void setDeuda(List<DeudaDTO> deuda) {
		this.deuda = deuda;
	}

	/**
	 * @return the historicoPieData
	 */
	public List<HistoricoPieDTO> getHistoricoPieData() {
		if(historicoPieData == null){
			historicoPieData = new ArrayList<>();
		}
		return historicoPieData;
	}

	/**
	 * @param historicoPieData the historicoPieData to set
	 */
	public void setHistoricoPieData(List<HistoricoPieDTO> historicoPieData) {
		this.historicoPieData = historicoPieData;
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
