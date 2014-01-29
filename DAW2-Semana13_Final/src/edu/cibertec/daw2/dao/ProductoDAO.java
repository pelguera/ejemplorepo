package edu.cibertec.daw2.dao;

import java.util.List;

import edu.cibertec.daw2.bean.ProductoDTO;

public interface ProductoDAO {

	public void insertarProducto(ProductoDTO prod) throws Exception;
	public void actualizarProducto(ProductoDTO prod) throws Exception;
	public void eliminarProducto(ProductoDTO prod) throws Exception;
	public ProductoDTO obtenerProducto(ProductoDTO prod) throws Exception;
	public List<ProductoDTO> obtenerTodosProducto(ProductoDTO prod) throws Exception;
	
}
