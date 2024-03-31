package co.edu.ue.model;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;


/**
 * The persistent class for the descuento database table.
 * 
 */
@Entity
@NamedQuery(name="Descuento.findAll", query="SELECT d FROM Descuento d")
public class Descuento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="iddescuento")
	private int iddescuento;

	@Column(name="codDescuento")
	private String codDescuento;

	@Temporal(TemporalType.DATE)
	@Column(name="fechaFin")
	private Date fechaFin;

	@Temporal(TemporalType.DATE)
	@Column(name="fechaInicio")
	private Date fechaInicio;
	
	@Column(name="porcentaje")
	private int porcentaje;

	public Descuento() {
	}

	public int getIddescuento() {
		return this.iddescuento;
	}

	public void setIddescuento(int iddescuento) {
		this.iddescuento = iddescuento;
	}

	public String getCodDescuento() {
		return this.codDescuento;
	}

	public void setCodDescuento(String codDescuento) {
		this.codDescuento = codDescuento;
	}

	public Date getFechaFin() {
		return this.fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public Date getFechaInicio() {
		return this.fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public int getPorcentaje() {
		return this.porcentaje;
	}

	public void setPorcentaje(int porcentaje) {
		this.porcentaje = porcentaje;
	}

}