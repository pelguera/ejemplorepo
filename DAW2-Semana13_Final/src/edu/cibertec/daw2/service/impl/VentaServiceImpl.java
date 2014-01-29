package edu.cibertec.daw2.service.impl;

import java.util.List;

import edu.cibertec.daw2.bean.BoletaDTO;
import edu.cibertec.daw2.bean.ClienteDTO;
import edu.cibertec.daw2.bean.ProductoDTO;
import edu.cibertec.daw2.dao.VentaDAO;
import edu.cibertec.daw2.dao.factory.DAOFactory;
import edu.cibertec.daw2.service.VentaService;

public class VentaServiceImpl implements VentaService {

	private VentaDAO dao;
	private DAOFactory fabrica = null;
	
	public VentaServiceImpl(int whichFactory){
		this.fabrica = DAOFactory.getDAOFactory(whichFactory);
		this.dao = this.fabrica.getVentaDAO();
	}
	
	@Override
	public List<BoletaDTO> obtenerVentas(BoletaDTO boleta) throws Exception {
		return this.dao.obtenerVentas(boleta);
	}

	@Override
	public void insertarVenta(BoletaDTO boleta) throws Exception {
		this.dao.insertarVenta(boleta);

	}

	@Override
	public void actualizarVenta(BoletaDTO boleta) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void eliminarVenta(BoletaDTO boleta) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public BoletaDTO obtenerVenta(BoletaDTO boleta) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ClienteDTO> obtenerVentasPorCliente() throws Exception {
		return this.dao.obtenerVentasPorCliente();
	}

	@Override
	public List<ProductoDTO> obtenerVentasPorProducto() throws Exception {
		return dao.obtenerVentasPorProducto();
	}

}
