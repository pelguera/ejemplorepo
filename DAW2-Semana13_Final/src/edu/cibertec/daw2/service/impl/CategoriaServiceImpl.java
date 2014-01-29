package edu.cibertec.daw2.service.impl;

import java.util.List;

import edu.cibertec.daw2.bean.CategoriaDTO;
import edu.cibertec.daw2.dao.CategoriaDAO;
import edu.cibertec.daw2.dao.factory.DAOFactory;
import edu.cibertec.daw2.service.CategoriaService;

public class CategoriaServiceImpl implements CategoriaService {

	private CategoriaDAO dao;
	private DAOFactory fabrica = null;
	
	public CategoriaServiceImpl(int whichFactory){
		this.fabrica = DAOFactory.getDAOFactory(whichFactory);
		this.dao = this.fabrica.getCategoriaDAO();
	}
	
	@Override
	public void insertarCategoria(CategoriaDTO cat) throws Exception {
		this.dao.insertarCategoria(cat);

	}

	@Override
	public void actualizarCategoria(CategoriaDTO cat) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void eliminarCategoria(CategoriaDTO cat) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public CategoriaDTO obtenerCategoria(CategoriaDTO cat) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CategoriaDTO> obtenerTodosCategorias() throws Exception {
		return this.dao.obtenerTodosCategorias();
	}

}
