package edu.cibertec.daw2.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the boleta database table.
 * 
 */
@Entity
public class Boleta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idboleta;

	@Temporal(TemporalType.DATE)
	private Date fecha;

	//bi-directional many-to-one association to Cliente
	@ManyToOne
	@JoinColumn(name="idcliente")
	private Cliente cliente;

	//bi-directional many-to-one association to ProductoHasBoleta
	@OneToMany(mappedBy="boleta")
	private List<ProductoHasBoleta> productoHasBoletas;

	public Boleta() {
	}

	public int getIdboleta() {
		return this.idboleta;
	}

	public void setIdboleta(int idboleta) {
		this.idboleta = idboleta;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<ProductoHasBoleta> getProductoHasBoletas() {
		return this.productoHasBoletas;
	}

	public void setProductoHasBoletas(List<ProductoHasBoleta> productoHasBoletas) {
		this.productoHasBoletas = productoHasBoletas;
	}

	public ProductoHasBoleta addProductoHasBoleta(ProductoHasBoleta productoHasBoleta) {
		getProductoHasBoletas().add(productoHasBoleta);
		productoHasBoleta.setBoleta(this);

		return productoHasBoleta;
	}

	public ProductoHasBoleta removeProductoHasBoleta(ProductoHasBoleta productoHasBoleta) {
		getProductoHasBoletas().remove(productoHasBoleta);
		productoHasBoleta.setBoleta(null);

		return productoHasBoleta;
	}

}