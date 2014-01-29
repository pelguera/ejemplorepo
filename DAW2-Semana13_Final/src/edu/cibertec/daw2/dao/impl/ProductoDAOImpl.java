package edu.cibertec.daw2.dao.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

import edu.cibertec.daw2.bean.CategoriaDTO;
import edu.cibertec.daw2.bean.ProductoDTO;
import edu.cibertec.daw2.dao.ProductoDAO;
import edu.cibertec.daw2.entity.Categoria;
import edu.cibertec.daw2.entity.Producto;

public class ProductoDAOImpl implements ProductoDAO {

	private EntityManagerFactory emf;
	private EntityManager em;

	public void setEntityManagerFactory(EntityManagerFactory emf ) {
		this.emf = emf;
	}
	
	@Override
	public void insertarProducto(ProductoDTO prod) throws Exception {
		em = emf.createEntityManager();
		
		Producto producto = new Producto();
		producto.setNombre(prod.getNombre());
		producto.setMarca(prod.getMarca());
		producto.setPrecio(prod.getPrecio());
		producto.setStock(prod.getStock());
		//Categoria
		Categoria categoria = new Categoria();
		categoria.setIdcategoria(prod.getCategoria().getIdcategoria());
		
		producto.setCategoria(categoria);
		try{
			em.getTransaction().begin();
			em.persist(producto);
			em.flush();
			em.getTransaction().commit();
			em.close();
			
		}catch(Exception e){
			em.getTransaction().rollback();
			e.printStackTrace();
		}

	}

	@Override
	public void actualizarProducto(ProductoDTO prod) throws Exception {
		em = emf.createEntityManager();
		
		Producto producto = em.find(Producto.class, prod.getIdproducto());
		producto.setMarca(prod.getMarca());
		producto.setNombre(prod.getNombre());
		producto.setPrecio(prod.getPrecio());
		producto.setStock(prod.getStock());
		
		Categoria categoria = em.find(Categoria.class, prod.getCategoria().getIdcategoria());
		producto.setCategoria(categoria);

		try{
			em.getTransaction().begin();
			em.merge(producto);
			em.flush();
			em.getTransaction().commit();
			em.close();
		}catch(Exception e){
			em.getTransaction().rollback();
			e.printStackTrace();
		}
		
	}

	@Override
	public void eliminarProducto(ProductoDTO prod) throws Exception {
		em = emf.createEntityManager();
		try{
			Producto producto = em.find(Producto.class, prod.getIdproducto());
			em.getTransaction().begin();
			em.remove(producto);
			em.flush();
			em.getTransaction().commit();		
			
		}catch(Exception e){
			em.getTransaction().rollback();
			e.printStackTrace();
		}
	}

	@Override
	public ProductoDTO obtenerProducto(ProductoDTO prod) throws Exception {
		em = emf.createEntityManager();
		
		Producto producto = em.find(Producto.class, prod.getIdproducto());
		
		ProductoDTO pDTO = new ProductoDTO();
		pDTO.setIdproducto(producto.getIdproducto());
		pDTO.setStock(producto.getStock());
		pDTO.setPrecio(producto.getPrecio());
		pDTO.setNombre(producto.getNombre());
		pDTO.setMarca(producto.getMarca());
		
		CategoriaDTO categoria = new CategoriaDTO();
		categoria.setIdcategoria(producto.getCategoria().getIdcategoria());
		categoria.setDescripcion(producto.getCategoria().getDescripcion());
		
		pDTO.setCategoria(categoria);
		
		return pDTO;
	}

	@Override
	public List<ProductoDTO> obtenerTodosProducto(ProductoDTO producto) throws Exception {
		List<ProductoDTO> listProducto = new ArrayList<ProductoDTO>();
		
		String query = "SELECT p.idproducto, p.marca, p.nombre, p.precio, p.stock, p.categoria FROM Producto p";
		if(producto != null){
			query = query + " WHERE 1 = 1 ";
			if(!producto.getNombre().equals(""))
				query = query + " AND p.nombre = :pNombre ";
			if(!producto.getMarca().equals(""))
				query = query + " AND p.marca = :pMarca ";
			if(producto.getCategoria().getIdcategoria() != 0)
				query = query + " AND p.categoria.idcategoria = :pIdCategoria ";
		}
		
		em = emf.createEntityManager();
		
		TypedQuery<Producto> q = em.createQuery(query, Producto.class);
		if(producto != null){
			if(!producto.getNombre().equals(""))
				q.setParameter("pNombre", producto.getNombre());
			if(!producto.getMarca().equals(""))
				q.setParameter("pMarca", producto.getMarca());
			if(producto.getCategoria().getIdcategoria() != 0)
				q.setParameter("pIdCategoria", producto.getCategoria().getIdcategoria());
		}		
		
		Iterator registro = q.getResultList().iterator();
		while(registro.hasNext() ){
			Object[] reg = (Object[])registro.next();
			
			ProductoDTO prod = new ProductoDTO();
			prod.setIdproducto(Integer.parseInt(reg[0].toString()));
			prod.setNombre(reg[2].toString());
			prod.setMarca(reg[1].toString());
			prod.setPrecio(Double.parseDouble(reg[3].toString()));
			prod.setStock(Integer.parseInt(reg[4].toString()));
			//set categoria
			Categoria c = (Categoria)reg[5];
			CategoriaDTO cat = new CategoriaDTO();
			cat.setIdcategoria(c.getIdcategoria());
			cat.setDescripcion(c.getDescripcion());
			
			prod.setCategoria(cat);
			
			listProducto.add(prod);
		}
		
		return listProducto;
	}

}
