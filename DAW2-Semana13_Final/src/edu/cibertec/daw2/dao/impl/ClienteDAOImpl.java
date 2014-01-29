package edu.cibertec.daw2.dao.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

import edu.cibertec.daw2.bean.ClienteDTO;
import edu.cibertec.daw2.dao.ClienteDAO;
import edu.cibertec.daw2.entity.Cliente;

public class ClienteDAOImpl implements ClienteDAO {

	private EntityManagerFactory emf;
	private EntityManager em;

	public void setEntityManagerFactory(EntityManagerFactory emf ) {
		this.emf = emf;
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
		List<ClienteDTO> listCliente = new ArrayList<ClienteDTO>();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try{
			String query = "SELECT c.idcliente, c.apellido, c.edad, c.fechaNacimiento, c.nombre FROM Cliente c";
			em = emf.createEntityManager();
			
			TypedQuery<Cliente> q = em.createQuery(query, Cliente.class);
			Iterator registro = q.getResultList().iterator();
			while(registro.hasNext() ){
				Object[] reg = (Object[])registro.next();
				
				ClienteDTO cliDTO = new ClienteDTO();
				cliDTO.setIdcliente(Integer.parseInt(reg[0].toString()));
				cliDTO.setApellido(reg[1].toString());
				cliDTO.setEdad(Integer.parseInt(reg[2].toString()));
				//cliDTO.setFechaNacimiento(new Date(Long.parseLong(reg[3].toString())));
				cliDTO.setNombre(reg[4].toString());
				listCliente.add(cliDTO);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return listCliente;
	}

}
