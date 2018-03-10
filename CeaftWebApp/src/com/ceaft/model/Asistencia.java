package com.ceaft.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table
public class Asistencia implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@NotNull
	@Column(name="ID_ASISTENCIA")
	private long idAsis;
	
	@Column(name="MATRICULA")
	private String matric;
	
	@Column(name="ID_ALUMNO")
	private long idAlum;
	
	@Column(name="FECHA")
	private Date fecha;

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

	public long getIdAlum() {
		return idAlum;
	}

	public void setIdAlum(long idAlum) {
		this.idAlum = idAlum;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
}
