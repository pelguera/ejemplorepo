package edu.cibertec.daw2.service;

import edu.cibertec.daw2.dao.factory.DAOFactory;
import edu.cibertec.daw2.service.impl.CategoriaServiceImpl;
import edu.cibertec.daw2.service.impl.ClienteServiceImpl;
import edu.cibertec.daw2.service.impl.ProductoServiceImpl;
import edu.cibertec.daw2.service.impl.VentaServiceImpl;

public class ApplicationBusinessDelegate {

	// Se especifica la factoria con la cual trabajamos
	// Se hace aqui para no ejecutarlo en cada Service.
	public CategoriaService getCategoriaService() {
		return new CategoriaServiceImpl( DAOFactory.JPA );
	}
	
	public ClienteService getClienteService(){
		return new ClienteServiceImpl(DAOFactory.JPA);
	}
	
	public ProductoService getProductoService(){
		return new ProductoServiceImpl(DAOFactory.JPA);
	}
	
	public VentaService getVentaService(){
		return new VentaServiceImpl(DAOFactory.JPA);
	}
}
