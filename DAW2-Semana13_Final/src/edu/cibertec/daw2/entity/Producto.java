package edu.cibertec.daw2.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the producto database table.
 * 
 */
@Entity
public class Producto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idproducto;

	private String marca;

	private String nombre;

	private double precio;

	private int stock;

	//bi-directional many-to-one association to Categoria
	@ManyToOne
	@JoinColumn(name="idcategoria")
	private Categoria categoria;

	//bi-directional many-to-one association to ProductoHasBoleta
	@OneToMany(mappedBy="producto")
	private List<ProductoHasBoleta> productoHasBoletas;

	public Producto() {
		categoria = new Categoria();
	}

	public int getIdproducto() {
		return this.idproducto;
	}

	public void setIdproducto(int idproducto) {
		this.idproducto = idproducto;
	}

	public String getMarca() {
		return this.marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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

	public Categoria getCategoria() {
		return this.categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public List<ProductoHasBoleta> getProductoHasBoletas() {
		return this.productoHasBoletas;
	}

	public void setProductoHasBoletas(List<ProductoHasBoleta> productoHasBoletas) {
		this.productoHasBoletas = productoHasBoletas;
	}

	public ProductoHasBoleta addProductoHasBoleta(ProductoHasBoleta productoHasBoleta) {
		getProductoHasBoletas().add(productoHasBoleta);
		productoHasBoleta.setProducto(this);

		return productoHasBoleta;
	}

	public ProductoHasBoleta removeProductoHasBoleta(ProductoHasBoleta productoHasBoleta) {
		getProductoHasBoletas().remove(productoHasBoleta);
		productoHasBoleta.setProducto(null);

		return productoHasBoleta;
	}

}