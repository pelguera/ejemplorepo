package edu.cibertec.daw2.service.impl;

import java.util.List;

import edu.cibertec.daw2.bean.ProductoDTO;
import edu.cibertec.daw2.dao.ProductoDAO;
import edu.cibertec.daw2.dao.factory.DAOFactory;
import edu.cibertec.daw2.service.ProductoService;

public class ProductoServiceImpl implements ProductoService {

	private ProductoDAO dao;
	private DAOFactory fabrica = null;
	
	public ProductoServiceImpl(int whichFactory){
		this.fabrica = DAOFactory.getDAOFactory(whichFactory);
		this.dao = this.fabrica.getProductoDAO();
	}
	
	@Override
	public void insertarProducto(ProductoDTO prod) throws Exception {
		this.dao.insertarProducto(prod);
	}

	@Override
	public void actualizarProducto(ProductoDTO prod) throws Exception {
		this.dao.actualizarProducto(prod);
	}

	@Override
	public void eliminarProducto(ProductoDTO prod) throws Exception {
		this.dao.eliminarProducto(prod);
	}

	@Override
	public ProductoDTO obtenerProducto(ProductoDTO prod) throws Exception {
		return this.dao.obtenerProducto(prod);
	}

	@Override
	public List<ProductoDTO> obtenerTodosProducto(ProductoDTO prod) throws Exception {
		return this.dao.obtenerTodosProducto(prod);
	}



}
