package edu.cibertec.daw2.bean;

import java.io.Serializable;

public class EstadisticaDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private ClienteDTO cliente;
	private ProductoDTO producto;
	private int cantidad;
	
	public ClienteDTO getCliente() {
		return cliente;
	}
	public void setCliente(ClienteDTO cliente) {
		this.cliente = cliente;
	}
	public ProductoDTO getProducto() {
		return producto;
	}
	public void setProducto(ProductoDTO producto) {
		this.producto = producto;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
}
