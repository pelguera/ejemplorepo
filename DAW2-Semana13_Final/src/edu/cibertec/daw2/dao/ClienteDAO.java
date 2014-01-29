package edu.cibertec.daw2.dao;

import java.util.List;

import edu.cibertec.daw2.bean.ClienteDTO;

public interface ClienteDAO {

	  public void insertarCliente(ClienteDTO cli) throws Exception;
	  public void actualizarCliente(ClienteDTO cli) throws Exception;
	  public void eliminarCliente(ClienteDTO cli) throws Exception;
	  public ClienteDTO obtenerCliente(ClienteDTO cli) throws Exception;
	  public List<ClienteDTO> obtenerTodosClientes() throws Exception;
	  
}
