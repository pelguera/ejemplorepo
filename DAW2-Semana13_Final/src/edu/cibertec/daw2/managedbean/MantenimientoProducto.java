package edu.cibertec.daw2.managedbean;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.validator.ValidatorException;

import org.primefaces.component.api.UIData;

import edu.cibertec.daw2.bean.CategoriaDTO;
import edu.cibertec.daw2.bean.ProductoDTO;
import edu.cibertec.daw2.service.ApplicationBusinessDelegate;
import edu.cibertec.daw2.service.CategoriaService;
import edu.cibertec.daw2.service.ProductoService;

@ManagedBean
public class MantenimientoProducto {

	private static ApplicationBusinessDelegate abd = new ApplicationBusinessDelegate();
	private static ProductoService prodService = abd.getProductoService();
	private static CategoriaService catService = abd.getCategoriaService();
	
	private List<ProductoDTO> productos;
	private ProductoDTO producto;
	private List<CategoriaDTO> categorias;
	private String msje;
	private String msjeRegistro;
	
	private UIData dttProductos;
	private int prod;
	private boolean inMostrarDlgElim;
	
	private String txtWeb;
	
	public MantenimientoProducto(){
		this.producto = new ProductoDTO();
		this.categorias = this.obtenerCategorias();
		this.productos = this.obtenerProductos();
	}
	
	private List<CategoriaDTO> obtenerCategorias(){
		List<CategoriaDTO> lista = null;
		try {
			lista = this.catService.obtenerTodosCategorias();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}
	
	private List<ProductoDTO> obtenerProductos(){
		List<ProductoDTO> lista = null;
		try {
			lista = this.prodService.obtenerTodosProducto(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}
	
	public String buscarProductos(){
		try {	
			this.productos = this.prodService.obtenerTodosProducto(this.getProducto());
			this.msje = "Se encontraron " + this.productos.size() + " registro(s)";
			this.limpiarProducto();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/ui/registroProducto.jsf";
	}
	
	public String nuevoProducto(){
		this.limpiarProducto();
		return "/ui/nuevoProducto.jsf";
	}
	
	public String insertaProducto(){		
		try {
			this.prodService.insertarProducto(this.producto);
			this.msjeRegistro = "Se registro el Producto satisfactoriamente.";			
			this.limpiarProducto();
		} catch (Exception e) {
			this.msjeRegistro = "Hubo problemas al registrar el Producto, intentelo nuevamente.";
			e.printStackTrace();
		}
		return "/ui/nuevoProducto.jsf";
	}
	
	public String irBandejaProductos(){
		this.limpiarProducto();
		return "/ui/registroProducto.jsf";
	}
	
	public String modificaProducto(){	
		this.producto = (ProductoDTO)this.dttProductos.getRowData();
		return "/ui/modificaProducto.jsf";
	}
	
	public String modificarProducto(){		
		try {
			this.prodService.actualizarProducto(this.producto);
			this.msjeRegistro = "Se actualizo el Producto satisfactoriamente.";				
			//this.limpiarProducto();
		} catch (Exception e) {
			this.msjeRegistro = "Hubo problemas al modificar el Producto, intentelo nuevamente.";
			e.printStackTrace();
		}
		return "/ui/modificaProducto.jsf";
	}	
	
	public String eliminaProducto(){
		this.producto = (ProductoDTO)this.dttProductos.getRowData();
		this.inMostrarDlgElim = true;
		return "/ui/registroProducto.jsf";
	}
	
    public void eliminarProducto(ActionEvent actionEvent){  
    	
    	this.inMostrarDlgElim = false;
    	System.out.println("--- " + this.producto.getIdproducto());
    	
    	try {
			this.prodService.eliminarProducto(this.producto);
			this.msje = "Se elimino el Producto satisfactoriamente.";
			this.limpiarProducto();
			this.productos = this.obtenerProductos();
		} catch (Exception e) {
			this.msje = "Hubo problemas al eliminar el Producto, intentelo nuevamente.";
			e.printStackTrace();
		} 
		         
    }	
	
	private void limpiarProducto(){
		this.getProducto().setIdproducto(0);
		this.getProducto().setCategoria(new CategoriaDTO());
		this.getProducto().setMarca(null);
		this.getProducto().setNombre(null);
		this.getProducto().setPrecio(0);
		this.getProducto().setStock(0);
	}
	
	public void validaMail(FacesContext fc, UIComponent uic, Object o) {
		String strValue = String.valueOf(o);
		if (!strValue.matches(".+@.+\\.[a-z]+")) {
			throw new ValidatorException(new FacesMessage("Formato de mail incorrecto"));
		}
	}	
	
	public ProductoDTO getProducto() {
		return producto;
	}

	public void setProducto(ProductoDTO producto) {
		this.producto = producto;
	}

	public List<CategoriaDTO> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<CategoriaDTO> categorias) {
		this.categorias = categorias;
	}

	public List<ProductoDTO> getProductos() {
		return productos;
	}

	public void setProductos(List<ProductoDTO> productos) {
		this.productos = productos;
	}

	public String getMsje() {
		return msje;
	}

	public void setMsje(String msje) {
		this.msje = msje;
	}

	public String getMsjeRegistro() {
		return msjeRegistro;
	}

	public void setMsjeRegistro(String msjeRegistro) {
		this.msjeRegistro = msjeRegistro;
	}

	public UIData getDttProductos() {
		return dttProductos;
	}

	public void setDttProductos(UIData dttProductos) {
		this.dttProductos = dttProductos;
	}

	public int getProd() {
		return prod;
	}

	public void setProd(int prod) {
		this.prod = prod;
	}

	public boolean isInMostrarDlgElim() {
		return inMostrarDlgElim;
	}

	public void setInMostrarDlgElim(boolean inMostrarDlgElim) {
		this.inMostrarDlgElim = inMostrarDlgElim;
	}

	public String getTxtWeb() {
		return txtWeb;
	}

	public void setTxtWeb(String txtWeb) {
		this.txtWeb = txtWeb;
	}
}
