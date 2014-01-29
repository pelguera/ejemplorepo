package edu.cibertec.daw2.dao.factory;

import edu.cibertec.daw2.dao.CategoriaDAO;
import edu.cibertec.daw2.dao.ClienteDAO;
import edu.cibertec.daw2.dao.ProductoDAO;
import edu.cibertec.daw2.dao.VentaDAO;

public abstract class DAOFactory {
    
    public static final int MYSQL = 1;
    public static final int ORACLE = 2;
    public static final int DB2 = 3;
    public static final int SQLSERVER = 4;
    public static final int XML = 5;
    public static final int MEMORY = 6;
    public static final int JPA = 7;
    
    // Existirá un método por cada DAO que pueda ser creado.
    // registramos nuestros daos
    public abstract CategoriaDAO getCategoriaDAO();
    
    public abstract ClienteDAO getClienteDAO();
    
    public abstract ProductoDAO getProductoDAO();
    
    public abstract VentaDAO getVentaDAO();
    
    public static DAOFactory getDAOFactory(int whichFactory) {
       switch(whichFactory){
      	case MYSQL:
       	    return new MySqlDAOFactory();
/*       	case XML:
       	    return new XmlDAOFactory();
       	case ORACLE:
       	    return new OracleDAOFactory();
       	case DB2:
       	    return new Db2DAOFactory();
       	case SQLSERVER:
       	    return new SqlServerDAOFactory();
       	case XML:
       	    return new XmlDAOFactory(); 
       	case MEMORY:
       	    return new MemoryDAOFactory();*/
    	case JPA:
       	    return new JPADAOFactory();

       	    
       	default:
       	    return null;
       }
    }
    
    
}
