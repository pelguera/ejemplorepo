package edu.cibertec.daw2.service;

import java.util.List;

import edu.cibertec.daw2.bean.BoletaDTO;
import edu.cibertec.daw2.bean.ClienteDTO;
import edu.cibertec.daw2.bean.ProductoDTO;

public interface VentaService {

	public List<BoletaDTO> obtenerVentas(BoletaDTO boleta) throws Exception;
	public void insertarVenta(BoletaDTO boleta) throws Exception;
	public void actualizarVenta(BoletaDTO boleta) throws Exception;
	public void eliminarVenta(BoletaDTO boleta) throws Exception;
	public BoletaDTO obtenerVenta(BoletaDTO boleta) throws Exception;
	public List<ClienteDTO> obtenerVentasPorCliente() throws Exception;
	public List<ProductoDTO> obtenerVentasPorProducto() throws Exception ;
	
}
