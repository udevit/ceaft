package com.ceaft.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
@Entity
@Table(name="CAPACITACION")

public class Capacitacion implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@NotNull
	@Column(name="ID_CAPACITACION")
	private long idCapacitacion;
	
	@Column(name="NOMBRE")
	private String nombre;

	public long getIdCapacitacion() {
		return idCapacitacion;
	}

	public void setIdCapacitacion(long idCapacitacion) {
		this.idCapacitacion = idCapacitacion;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	

}
