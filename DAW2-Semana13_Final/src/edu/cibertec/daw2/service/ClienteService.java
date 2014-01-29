package edu.cibertec.daw2.service;

import java.util.List;

import edu.cibertec.daw2.bean.ClienteDTO;


public interface ClienteService {

	  public void insertarCliente(ClienteDTO cli) throws Exception;
	  public void actualizarCliente(ClienteDTO cli) throws Exception;
	  public void eliminarCliente(ClienteDTO cli) throws Exception;
	  public ClienteDTO obtenerCliente(ClienteDTO cli) throws Exception;
	  public List<ClienteDTO> obtenerTodosClientes() throws Exception;
}
