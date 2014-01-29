package edu.cibertec.daw2.dao;

import java.util.List;

import edu.cibertec.daw2.bean.CategoriaDTO;

public interface CategoriaDAO {
	
	  public void insertarCategoria(CategoriaDTO cat) throws Exception;
	  public void actualizarCategoria(CategoriaDTO cat) throws Exception;
	  public void eliminarCategoria(CategoriaDTO cat) throws Exception;
	  public CategoriaDTO obtenerCategoria(CategoriaDTO cat) throws Exception;
	  public List<CategoriaDTO> obtenerTodosCategorias() throws Exception;
	  
}
