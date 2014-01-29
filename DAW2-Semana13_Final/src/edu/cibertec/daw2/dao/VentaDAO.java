package edu.cibertec.daw2.dao;

import java.util.List;

import edu.cibertec.daw2.bean.BoletaDTO;
import edu.cibertec.daw2.bean.ClienteDTO;
import edu.cibertec.daw2.bean.ProductoDTO;

public interface VentaDAO {

	public List<BoletaDTO> obtenerVentas(BoletaDTO boleta) throws Exception;
	public void insertarVenta(BoletaDTO boleta) throws Exception;
	public void actualizarVenta(BoletaDTO boleta) throws Exception;
	public void eliminarVenta(BoletaDTO boleta) throws Exception;
	public BoletaDTO obtenerVenta(BoletaDTO boleta) throws Exception;
	public List<ClienteDTO> obtenerVentasPorCliente() throws Exception;
	public List<ProductoDTO> obtenerVentasPorProducto() throws Exception;
	
	
}
