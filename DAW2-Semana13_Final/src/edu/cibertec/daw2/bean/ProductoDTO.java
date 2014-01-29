package edu.cibertec.daw2.bean;

import java.io.Serializable;

public class ProductoDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private int idproducto;
	private String marca;
	private String nombre;
	private double precio;
	private int stock;
	private CategoriaDTO categoria;
	private boolean fgEdicion;
	private int cantVentas;
	
	
	public ProductoDTO(){
		this.categoria = new CategoriaDTO();
	}
	public int getCantVentas() {
		return cantVentas;
	}

	public void setCantVentas(int cantVentas) {
		this.cantVentas = cantVentas;
	}

	public int getIdproducto() {
		return idproducto;
	}
	public void setIdproducto(int idproducto) {
		this.idproducto = idproducto;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public CategoriaDTO getCategoria() {
		return categoria;
	}
	public void setCategoria(CategoriaDTO categoria) {
		this.categoria = categoria;
	}

	public boolean isFgEdicion() {
		return fgEdicion;
	}

	public void setFgEdicion(boolean fgEdicion) {
		this.fgEdicion = fgEdicion;
	}	
	
}
