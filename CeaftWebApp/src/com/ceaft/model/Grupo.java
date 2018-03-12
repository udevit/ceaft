package com.ceaft.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table
public class Grupo implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@NotNull
	@Column(name="ID_GRUPO")
	private long idGpo;
	
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "grupo", cascade = CascadeType.ALL)
	private Curso curso;
		
	@Column(name="FECHA_INICIO")
	private Date fechaI;
	
	@Column(name="FECHA_FIN")
	private Date fechaF;
	
	@Column(name="HORARIO")
	private String horario;
	
	@Column(name="GRUPO")
	private String grupo;
	
	@Column(name="PROFESOR")
	private String prof;
	
	@Column(name="AULA")
	private String aula;
	
	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	private AlumnoMatriculado alumnoMatric;
	
	public AlumnoMatriculado getAlumnoMatric() {
		return alumnoMatric;
	}

	public void setAlumnoMatric(AlumnoMatriculado alumnoMatric) {
		this.alumnoMatric = alumnoMatric;
	}

	public long getIdGpo() {
		return idGpo;
	}

	public void setIdGpo(long idGpo) {
		this.idGpo = idGpo;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Date getFechaI() {
		return fechaI;
	}

	public void setFechaI(Date fechaI) {
		this.fechaI = fechaI;
	}

	public Date getFechaF() {
		return fechaF;
	}

	public void setFechaF(Date fechaF) {
		this.fechaF = fechaF;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public String getGrupo() {
		return grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	public String getProf() {
		return prof;
	}

	public void setProf(String prof) {
		this.prof = prof;
	}

	public String getAula() {
		return aula;
	}

	public void setAula(String aula) {
		this.aula = aula;
	}
	
}