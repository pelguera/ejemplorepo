package edu.cibertec.daw2.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

import edu.cibertec.daw2.bean.CategoriaDTO;
import edu.cibertec.daw2.dao.CategoriaDAO;
import edu.cibertec.daw2.entity.Categoria;

public class CategoriaDAOImpl implements CategoriaDAO {

	private EntityManagerFactory emf;
	private EntityManager em;

	public void setEntityManagerFactory(EntityManagerFactory emf ) {
		this.emf = emf;
	}
	
	@Override
	public void insertarCategoria(CategoriaDTO cat) throws Exception {
		Categoria categoria = new Categoria();
		categoria.setDescripcion(cat.getDescripcion());
		try{
			em=emf.createEntityManager();
			em.getTransaction().begin();
			em.persist(categoria);
			em.flush();
			em.getTransaction().commit();
			em.close();
		}catch(Exception e){
			em.getTransaction().rollback();
			e.printStackTrace();
		}

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
		String query = "SELECT c FROM Categoria c";		
		em=emf.createEntityManager();
		TypedQuery<Categoria> q = em.createQuery(query, Categoria.class);		
		List<Categoria> lista = q.getResultList();
		
		List<CategoriaDTO> listCategoria = new ArrayList<CategoriaDTO>();
		for(Categoria categoria : lista){
			CategoriaDTO catDTO = new CategoriaDTO();
			catDTO.setIdcategoria(categoria.getIdcategoria());
			catDTO.setDescripcion(categoria.getDescripcion());
			
			listCategoria.add(catDTO);
		}
		
		return listCategoria;
	}

}
