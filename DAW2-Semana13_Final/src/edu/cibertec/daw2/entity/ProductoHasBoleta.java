package edu.cibertec.daw2.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the producto_has_boleta database table.
 * 
 */
@Entity
@Table(name="producto_has_boleta")
public class ProductoHasBoleta implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ProductoHasBoletaPK id;

	private double precio;

	private int stock;

	//bi-directional many-to-one association to Producto
	@ManyToOne
	@JoinColumn(name="idproducto", referencedColumnName = "idproducto", insertable = false, updatable = false)
	private Producto producto;

	//bi-directional many-to-one association to Boleta
	@ManyToOne
	@JoinColumn(name="idboleta", referencedColumnName = "idboleta", insertable = false, updatable = false)
	private Boleta boleta;

	public ProductoHasBoleta() {
	}

	public ProductoHasBoletaPK getId() {
		return this.id;
	}

	public void setId(ProductoHasBoletaPK id) {
		this.id = id;
	}

	public double getPrecio() {
		return this.precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getStock() {
		return this.stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public Producto getProducto() {
		return this.producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Boleta getBoleta() {
		return this.boleta;
	}

	public void setBoleta(Boleta boleta) {
		this.boleta = boleta;
	}

}