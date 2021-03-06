package com.ceaft.model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="DEUDAS")
public class Deuda implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="IDDEUDA")
	private long idDeuda;
	
	@Column(name="MATRICULA")
	private String matric;
	
	@Column(name="ADEUDO_TOTAL")
	private BigDecimal adeudoTot;

	@Column(name="MONTO_RECUPERADO")
	private Double montoRecup;
	
	@Column(name="MONTO_CARGO_EXTRA")
	private Double montoExtra;
	
	@Column(name="FOLIO")
	private long folio;

	public long getIdDeuda() {
		return idDeuda;
	}

	public void setIdDeuda(long idDeuda) {
		this.idDeuda = idDeuda;
	}

	public String getMatric() {
		return matric;
	}

	public void setMatric(String matric) {
		this.matric = matric;
	}

	public BigDecimal getAdeudoTot() {
		return adeudoTot;
	}

	public void setAdeudoTot(BigDecimal adeudoTot) {
		this.adeudoTot = adeudoTot;
	}

	public Double getMontoRecup() {
		return montoRecup;
	}

	public void setMontoRecup(Double montoRecup) {
		this.montoRecup = montoRecup;
	}

	public Double getMontoExtra() {
		return montoExtra;
	}

	public void setMontoExtra(Double montoExtra) {
		this.montoExtra = montoExtra;
	}

	public long getFolio() {
		return folio;
	}

	public void setFolio(long folio) {
		this.folio = folio;
	}

	public boolean equals(Object obj){
		if(!(obj instanceof Deuda) || ((Deuda)obj).getIdDeuda() != this.getIdDeuda()){
			return false;
		}
		return true;
	}
	
}