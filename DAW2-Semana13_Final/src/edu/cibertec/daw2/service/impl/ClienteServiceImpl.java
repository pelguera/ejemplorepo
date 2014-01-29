package edu.cibertec.daw2.service.impl;

import java.util.List;

import edu.cibertec.daw2.bean.ClienteDTO;
import edu.cibertec.daw2.dao.ClienteDAO;
import edu.cibertec.daw2.dao.factory.DAOFactory;
import edu.cibertec.daw2.service.ClienteService;

public class ClienteServiceImpl implements ClienteService {

	private ClienteDAO dao;
	private DAOFactory fabrica = null;
	
	public ClienteServiceImpl(int whichFactory){
		this.fabrica = DAOFactory.getDAOFactory(whichFactory);
		this.dao = this.fabrica.getClienteDAO();
	}
	
	@Override
	public void insertarCliente(ClienteDTO cli) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void actualizarCliente(ClienteDTO cli) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void eliminarCliente(ClienteDTO cli) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public ClienteDTO obtenerCliente(ClienteDTO cli) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ClienteDTO> obtenerTodosClientes() throws Exception {
		return this.dao.obtenerTodosClientes();
	}

}
