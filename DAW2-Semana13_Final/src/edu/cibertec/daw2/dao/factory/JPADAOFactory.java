package edu.cibertec.daw2.dao.factory;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import edu.cibertec.daw2.dao.CategoriaDAO;
import edu.cibertec.daw2.dao.ClienteDAO;
import edu.cibertec.daw2.dao.ProductoDAO;
import edu.cibertec.daw2.dao.VentaDAO;
import edu.cibertec.daw2.dao.impl.CategoriaDAOImpl;
import edu.cibertec.daw2.dao.impl.ClienteDAOImpl;
import edu.cibertec.daw2.dao.impl.ProductoDAOImpl;
import edu.cibertec.daw2.dao.impl.VentaDAOImpl;

public class JPADAOFactory extends DAOFactory {

	private EntityManagerFactory emf;
	
	public JPADAOFactory (){
		/*
		 * 	Referenciamos a nuestra unidad de persistencia
		 *	JPA-Web para gestionar nuestras entidades
		 */
		emf=Persistence.createEntityManagerFactory("JPA-Web");

	}

	@Override
	public CategoriaDAO getCategoriaDAO() {
		CategoriaDAOImpl cd = new CategoriaDAOImpl();
		cd.setEntityManagerFactory(emf);
		return (CategoriaDAO)cd;
	}

	@Override
	public ClienteDAO getClienteDAO() {
		ClienteDAOImpl cd = new ClienteDAOImpl();
		cd.setEntityManagerFactory(emf);
		return (ClienteDAO)cd;
	}

	@Override
	public ProductoDAO getProductoDAO() {
		ProductoDAOImpl prod = new ProductoDAOImpl();
		prod.setEntityManagerFactory(emf);
		return (ProductoDAO)prod;
	}
	
	public VentaDAO getVentaDAO(){
		VentaDAOImpl venta = new VentaDAOImpl();
		venta.setEntityManagerFactory(emf);
		return (VentaDAO)venta;
	}
}
