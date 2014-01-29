package edu.cibertec.daw2.managedbean;

import java.util.List;

import javax.faces.bean.ManagedBean;

import org.primefaces.component.api.UIData;

import edu.cibertec.daw2.bean.BoletaDTO;
import edu.cibertec.daw2.bean.ClienteDTO;
import edu.cibertec.daw2.bean.ProductoDTO;
import edu.cibertec.daw2.service.ApplicationBusinessDelegate;
import edu.cibertec.daw2.service.ClienteService;
import edu.cibertec.daw2.service.ProductoService;
import edu.cibertec.daw2.service.VentaService;

@ManagedBean
public class MantenimientoVenta {

	private static ApplicationBusinessDelegate abd = new ApplicationBusinessDelegate();
	private static ClienteService cliServ = abd.getClienteService();
	private static ProductoService prodService = abd.getProductoService();
	private static VentaService ventaService = abd.getVentaService();
	
	private BoletaDTO boleta;
	private List<ClienteDTO> clientes;
	private List<BoletaDTO> boletas;
	private List<ProductoDTO> productos;
	private String msje;
	private UIData dttVentas;
	private String msjeRegistro;
	
	private List<String> listIdProductos;
	
	public MantenimientoVenta(){
		this.boleta = new BoletaDTO();
		this.clientes = this.obtenerClientes();
		this.productos = this.obtenerProductos();
		this.boletas = this.obtenerVentas();
	}
	
	private List<ClienteDTO> obtenerClientes(){
		List<ClienteDTO> lista = null;
		try{
			lista = this.cliServ.obtenerTodosClientes();
		}catch(Exception e){
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
	
	private List<BoletaDTO> obtenerVentas(){
		List<BoletaDTO> lista = null;
		try{
			lista = this.ventaService.obtenerVentas(boleta);
		}catch(Exception e){
			e.printStackTrace();
		}
		return lista;
	}
	
	public String buscarVentas(){		
		try{
			this.boletas = this.ventaService.obtenerVentas(boleta);
			this.msje = "Se encontraron " + this.boletas.size() + " registros.";
		}catch(Exception e){
			e.printStackTrace();
		}		
		return "/ui/registroVenta.jsf";
	}
	
	public String nuevaVenta(){
		
		return "/ui/nuevaVenta.jsf";
	}
	
	public String grabarVenta(){
		try {
			for(String idproducto : this.listIdProductos){
				ProductoDTO pro = new ProductoDTO();			
				pro.setIdproducto(Integer.parseInt(idproducto));
				
				pro = this.prodService.obtenerProducto(pro);
				boleta.getProductos().add(pro);
			}
			
			this.ventaService.insertarVenta(boleta);
			this.limpiarVenta();
			this.msjeRegistro = "Se grabo la Venta satisfactoriamente.";
		} catch (Exception e) {
			this.msjeRegistro = "Hubo problemas al grabar la Venta, intentelo nuevamente.";
			e.printStackTrace();
		}
		
		return "/ui/nuevaVenta.jsf";
	}
	
	private void limpiarVenta(){
		this.getBoleta().setCliente(new ClienteDTO());
		this.getBoleta().setFecha(null);
		this.getBoleta().setIdboleta(0);
		this.getBoleta().setProductos(null);
	}
	
	public String cancelarVenta(){
		
		return "/ui/registroVenta.jsf";
	}
	
	public BoletaDTO getBoleta() {
		return boleta;
	}

	public void setBoleta(BoletaDTO boleta) {
		this.boleta = boleta;
	}

	public List<ClienteDTO> getClientes() {
		return clientes;
	}

	public void setClientes(List<ClienteDTO> clientes) {
		this.clientes = clientes;
	}

	public List<BoletaDTO> getBoletas() {
		return boletas;
	}

	public void setBoletas(List<BoletaDTO> boletas) {
		this.boletas = boletas;
	}

	public String getMsje() {
		return msje;
	}

	public void setMsje(String msje) {
		this.msje = msje;
	}

	public UIData getDttVentas() {
		return dttVentas;
	}

	public void setDttVentas(UIData dttVentas) {
		this.dttVentas = dttVentas;
	}

	public List<ProductoDTO> getProductos() {
		return productos;
	}

	public void setProductos(List<ProductoDTO> productos) {
		this.productos = productos;
	}

	public List<String> getListIdProductos() {
		return listIdProductos;
	}

	public void setListIdProductos(List<String> listIdProductos) {
		this.listIdProductos = listIdProductos;
	}

	public String getMsjeRegistro() {
		return msjeRegistro;
	}

	public void setMsjeRegistro(String msjeRegistro) {
		this.msjeRegistro = msjeRegistro;
	}
	
	
}
