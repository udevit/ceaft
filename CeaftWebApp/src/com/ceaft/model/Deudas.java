package com.ceaft.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
@Entity
@Table(name="DEUDAS")
public class Deudas implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@NotNull
	@Column(name="ID_DEUDA")
	private long idDeuda;
	
	@Column(name="MATRICULA")
	private String matricula;
	
	@Column(name="ADEUDO_TOTAL")
	private BigDecimal adeudoTotal;

	@Column(name="MONTO_RECUPERADO")
	private BigDecimal montoRecuperado;
	
	@Column(name="MONTO_CARGO_EXTRA")
	private BigDecimal montoCargoExtra;
	
	@Column(name="FOLIO")
	private int folio;

	public long getIdDeuda() {
		return idDeuda;
	}

	public void setIdDeuda(long idDeuda) {
		this.idDeuda = idDeuda;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public BigDecimal getAdeudoTotal() {
		return adeudoTotal;
	}

	public void setAdeudoTotal(BigDecimal adeudoTotal) {
		this.adeudoTotal = adeudoTotal;
	}

	public BigDecimal getMontoRecuperado() {
		return montoRecuperado;
	}

	public void setMontoRecuperado(BigDecimal montoRecuperado) {
		this.montoRecuperado = montoRecuperado;
	}

	public BigDecimal getMontoCargoExtra() {
		return montoCargoExtra;
	}

	public void setMontoCargoExtra(BigDecimal montoCargoExtra) {
		this.montoCargoExtra = montoCargoExtra;
	}

	public int getFolio() {
		return folio;
	}

	public void setFolio(int folio) {
		this.folio = folio;
	}
	
	
}
