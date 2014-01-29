package edu.cibertec.daw2.managedbean;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import edu.cibertec.daw2.bean.CategoriaDTO;
import edu.cibertec.daw2.service.ApplicationBusinessDelegate;
import edu.cibertec.daw2.service.CategoriaService;

@RequestScoped
@ManagedBean
public class MantenimientoCategoria {
	
	private static ApplicationBusinessDelegate abd = new ApplicationBusinessDelegate();
	private static CategoriaService catService = abd.getCategoriaService();
	
	private String nomCategoria;
	private List<CategoriaDTO> listaCategoria; 
	private CategoriaDTO categoria;
	private String msje;
	
	public MantenimientoCategoria(){
		this.categoria = new CategoriaDTO();
		this.llenarListaCategorias();
	}
	
	public String registro() {
		
		try {
			catService.insertarCategoria(categoria);
			//FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Se registro la Categoria Satisfactoriamente", null)); 
			this.categoria.setDescripcion("");
			this.msje = "Se registro la Categoria Satisfactoriamente";
			
			this.llenarListaCategorias();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	    return "/ui/registroCategoria.jsf";
	}
	
	public void llenarListaCategorias(){		
		try {
			this.listaCategoria = catService.obtenerTodosCategorias();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getNomCategoria() {
		return nomCategoria;
	}

	public void setNomCategoria(String nomCategoria) {
		this.nomCategoria = nomCategoria;
	}

	public List<CategoriaDTO> getListaCategoria() {
		return listaCategoria;
	}

	public void setListaCategoria(List<CategoriaDTO> listaCategoria) {
		this.listaCategoria = listaCategoria;
	}

	public CategoriaDTO getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaDTO categoria) {
		this.categoria = categoria;
	}

	public String getMsje() {
		return msje;
	}

	public void setMsje(String msje) {
		this.msje = msje;
	}
}
