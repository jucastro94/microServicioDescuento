package co.edu.ue.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;


/**
 * The persistent class for the productodescuento database table.
 * 
 */
@Entity
@NamedQuery(name="Productodescuento.findAll", query="SELECT p FROM Productodescuento p")
public class Productodescuento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idProductoDescuento")
	private int idProductoDescuento;

	@Column(name="FK_descuento")
	private int FK_descuento;
	
	@Column(name="FK_producto")
	private int FK_producto;

	public Productodescuento() {
	}

	public int getIdProductoDescuento() {
		return this.idProductoDescuento;
	}

	public void setIdProductoDescuento(int idProductoDescuento) {
		this.idProductoDescuento = idProductoDescuento;
	}

	public int getFK_descuento() {
		return this.FK_descuento;
	}

	public void setFK_descuento(int FK_descuento) {
		this.FK_descuento = FK_descuento;
	}

	public int getFK_producto() {
		return this.FK_producto;
	}

	public void setFK_producto(int FK_producto) {
		this.FK_producto = FK_producto;
	}

}