package com.ceaft.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Asistencia implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	//@GeneratedValue(strategy=GenerationType.AUTO)
	@SequenceGenerator(name = "SEQ",sequenceName = "SEQ_ASISTENCIA_ID",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.IDENTITY, generator="SEQ")
	@Column(name="ID_ASISTENCIA")
	private long idAsis;
	
	@Column(name="MATRICULA")
	private String matric;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="ID_ALUMNO")
	private AlumnoMatriculado alumnoMatriculado;
	
	@Temporal(TemporalType.DATE)
	@Column(name="FECHA")
	private Date fecha;

	/**
	 * 
	 */
	public Asistencia(){
		
	}
	
	/**
	 * 
	 * @param matric
	 * @param fecha
	 */
	public Asistencia(String matric, Date fecha){
		this.matric = matric;
		this.fecha = fecha;
	}

	public long getIdAsis() {
		return idAsis;
	}

	public void setIdAsis(long idAsis) {
		this.idAsis = idAsis;
	}

	public String getMatric() {
		return matric;
	}

	public void setMatric(String matric) {
		this.matric = matric;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public AlumnoMatriculado getAlumnoMatriculado() {
		return alumnoMatriculado;
	}

	public void setAlumnoMatriculado(AlumnoMatriculado alumnoMatriculado) {
		this.alumnoMatriculado = alumnoMatriculado;
	}
	
}
