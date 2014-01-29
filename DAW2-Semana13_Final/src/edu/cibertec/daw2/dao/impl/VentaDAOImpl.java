package edu.cibertec.daw2.dao.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import edu.cibertec.daw2.bean.BoletaDTO;
import edu.cibertec.daw2.bean.ClienteDTO;
import edu.cibertec.daw2.bean.ProductoDTO;
import edu.cibertec.daw2.dao.VentaDAO;
import edu.cibertec.daw2.entity.Boleta;
import edu.cibertec.daw2.entity.Cliente;
import edu.cibertec.daw2.entity.Producto;
import edu.cibertec.daw2.entity.ProductoHasBoleta;
import edu.cibertec.daw2.entity.ProductoHasBoletaPK;

public class VentaDAOImpl implements VentaDAO {

	private EntityManagerFactory emf;
	private EntityManager em;

	public void setEntityManagerFactory(EntityManagerFactory emf ) {
		this.emf = emf;
	}
	
	@Override
	public List<BoletaDTO> obtenerVentas(BoletaDTO boleta) throws Exception {
		List<BoletaDTO> lista = new ArrayList<BoletaDTO>();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try{
			String query = "SELECT b.idboleta, b.fecha, c.idcliente, c.nombre, c.apellido FROM Boleta b LEFT JOIN b.cliente c ";
			if(boleta != null){
				query += " WHERE 1 = 1 ";
				if(boleta.getCliente() != null && boleta.getCliente().getIdcliente() != 0)
					query += " AND c.idcliente = :idcliente ";
				if(boleta.getFecha() != null)
					query += " AND b.fecha = :fecha ";
			}
			
			em = emf.createEntityManager();
			
			Query q = em.createQuery(query);
			if(boleta != null){
				if(boleta.getCliente() != null && boleta.getCliente().getIdcliente() != 0)
					q.setParameter("idcliente", boleta.getCliente().getIdcliente());
				if(boleta.getFecha() != null)
					q.setParameter("fecha", boleta.getFecha());
			}
			
			Iterator listaFinal = q.getResultList().iterator();
			while(listaFinal.hasNext()){
				BoletaDTO bolDTO = new BoletaDTO();
				Object[] obj = (Object[]) listaFinal.next();
				bolDTO.setIdboleta(Integer.parseInt(obj[0].toString()));
				Date fecha = (Date)obj[1];
				bolDTO.setFecha(fecha);
				bolDTO.setFechaFormat(sdf.format(new Date(fecha.getTime())));
				ClienteDTO cliDTO = new ClienteDTO();
				cliDTO.setIdcliente(Integer.parseInt(obj[2].toString()));
				cliDTO.setNombre(obj[3].toString());
				cliDTO.setApellido(obj[4].toString());
				bolDTO.setCliente(cliDTO);
				
				lista.add(bolDTO);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return lista;
	}

	@Override
	public void insertarVenta(BoletaDTO boleta) throws Exception {
		em = emf.createEntityManager();
		
		try{
			Boleta bol = new Boleta();
			bol.setFecha(boleta.getFecha());
			
			//agregando cliente
			Cliente cliente = new Cliente();
			cliente = em.find(Cliente.class, boleta.getCliente().getIdcliente());
			bol.setCliente(cliente);
			
			em.getTransaction().begin();			
			em.persist(bol);
			em.flush();			
			//em.getTransaction().commit();				

			//agregando los productos
			for(ProductoDTO pro : boleta.getProductos()){				
				
				ProductoHasBoletaPK prodPK = new ProductoHasBoletaPK();
				prodPK.setIdboleta(bol.getIdboleta());
				prodPK.setIdproducto(pro.getIdproducto());
				
				ProductoHasBoleta prodBol = new ProductoHasBoleta();
				prodBol.setId(prodPK);
				
				prodBol.setPrecio(pro.getPrecio());
				prodBol.setStock(pro.getStock());
				
				em.persist(prodBol);

			}		
			em.getTransaction().commit();
			em.close();		
						
		}catch(Exception e){
			em.getTransaction().rollback();
			e.printStackTrace();
		}

	}

	@Override
	public void actualizarVenta(BoletaDTO boleta) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void eliminarVenta(BoletaDTO boleta) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public BoletaDTO obtenerVenta(BoletaDTO boleta) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ClienteDTO> obtenerVentasPorCliente() throws Exception {
		List<ClienteDTO> lista = new ArrayList<ClienteDTO>();
		String query = "SELECT c FROM Cliente c";		
		try{
			em = emf.createEntityManager();
			TypedQuery<Cliente> q = em.createQuery(query, Cliente.class);
			
			Iterator registro = q.getResultList().iterator();
			while(registro.hasNext()){
				ClienteDTO cliDTO = new ClienteDTO();
				Cliente cli = (Cliente)registro.next();				
				cliDTO.setIdcliente(cli.getIdcliente());
				cliDTO.setNombre(cli.getNombre());
				cliDTO.setApellido(cli.getApellido());
				
				String query1 = "SELECT count(b) FROM Boleta b WHERE b.cliente.idcliente = :cli";
				Query q1 = em.createQuery(query1); 
				q1.setParameter("cli", cli.getIdcliente());
				Integer cantidad = Integer.parseInt(q1.getSingleResult().toString());
				
				cliDTO.setCantVentas(cantidad);
				
				lista.add(cliDTO);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return lista;
	}

	@Override
	public List<ProductoDTO> obtenerVentasPorProducto() throws Exception {
		
		List<ProductoDTO> lista = new ArrayList<ProductoDTO>();
		String query = "SELECT p FROM Producto p";		
		try{
			em = emf.createEntityManager();
			TypedQuery<Producto> q = em.createQuery(query, Producto.class);
			
			List<Producto>   data = q.getResultList();
			for(Producto p :data){
				ProductoDTO aux = new ProductoDTO();
				aux.setIdproducto(p.getIdproducto());
				aux.setNombre(p.getNombre());

				String query1 = 
					"SELECT count(p) FROM ProductoHasBoleta p where p.id.idproducto = :par";	
				Query q1 = em.createQuery(query1);
				q1.setParameter("par", p.getIdproducto());
				
				Integer cantidad = Integer.parseInt(String.valueOf(q1.getSingleResult()));
				aux.setCantVentas(cantidad);
				lista.add(aux);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return lista;
	}

}
