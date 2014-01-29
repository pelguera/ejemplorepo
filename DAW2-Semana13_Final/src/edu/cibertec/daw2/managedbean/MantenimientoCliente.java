package edu.cibertec.daw2.managedbean;

import java.util.Date;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class MantenimientoCliente {

	private String nomCliente;
	private String apeCliente;
	private int edadCliente;
	private Date fecNacCliente;
	
	public String registro(){
		/*
		ClienteJPA cliJPA = new ClienteJPA();
		try{
			cliJPA.insertar(this.nomCliente, this.apeCliente, this.edadCliente, this.fecNacCliente);	
		}catch(Exception e){
			e.printStackTrace();
		}
		*/		
		return "regCliente";
	}
	
	public String getNomCliente() {
		return nomCliente;
	}
	public void setNomCliente(String nomCliente) {
		this.nomCliente = nomCliente;
	}
	public String getApeCliente() {
		return apeCliente;
	}
	public void setApeCliente(String apeCliente) {
		this.apeCliente = apeCliente;
	}
	public int getEdadCliente() {
		return edadCliente;
	}
	public void setEdadCliente(int edadCliente) {
		this.edadCliente = edadCliente;
	}
	public Date getFecNacCliente() {
		return fecNacCliente;
	}
	public void setFecNacCliente(Date fecNacCliente) {
		this.fecNacCliente = fecNacCliente;
	}

}
