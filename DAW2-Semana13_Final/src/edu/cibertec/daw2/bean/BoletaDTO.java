package edu.cibertec.daw2.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BoletaDTO implements Serializable {

	private static final long serialVersionUID = -1682446734709127367L;
	private int idboleta;
	private Date fecha;
	private String fechaFormat;
	private ClienteDTO cliente;
	private List<ProductoDTO> productos;
	
	public BoletaDTO(){
		this.cliente = new ClienteDTO();
		this.productos = new ArrayList<ProductoDTO>();
	}
	
	public int getIdboleta() {
		return idboleta;
	}
	public void setIdboleta(int idboleta) {
		this.idboleta = idboleta;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public ClienteDTO getCliente() {
		return cliente;
	}
	public void setCliente(ClienteDTO cliente) {
		this.cliente = cliente;
	}
	public List<ProductoDTO> getProductos() {
		return productos;
	}
	public void setProductos(List<ProductoDTO> productos) {
		this.productos = productos;
	}

	public String getFechaFormat() {
		return fechaFormat;
	}

	public void setFechaFormat(String fechaFormat) {
		this.fechaFormat = fechaFormat;
	}	
	
}
