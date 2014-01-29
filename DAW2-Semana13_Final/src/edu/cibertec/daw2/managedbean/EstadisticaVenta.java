package edu.cibertec.daw2.managedbean;

import java.util.List;

import javax.faces.bean.ManagedBean;

import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.PieChartModel;

import edu.cibertec.daw2.bean.ClienteDTO;
import edu.cibertec.daw2.bean.ProductoDTO;
import edu.cibertec.daw2.service.ApplicationBusinessDelegate;
import edu.cibertec.daw2.service.VentaService;

@ManagedBean
public class EstadisticaVenta {

	private static ApplicationBusinessDelegate abd = new ApplicationBusinessDelegate();
	private static VentaService ventaService = abd.getVentaService();
	private PieChartModel pieModel, pieModelProducto;
	private CartesianChartModel barraModel;
	private List<ClienteDTO> listVentPorCliente;
	private List<ProductoDTO> listVentPorProducto;
	
	public EstadisticaVenta(){
		this.llenarEstadisticaVenta();
		this.llenarEstadisticaVentaPorProducto();
	}	
	

	private void llenarEstadisticaVentaPorProducto(){
        
        try {
			this.listVentPorProducto = this.ventaService.obtenerVentasPorProducto();
			
			pieModelProducto = new PieChartModel();  
	        
			for(ProductoDTO aux : this.listVentPorProducto){
				pieModelProducto.set(aux.getNombre(), aux.getCantVentas());  				
			}
	        
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void llenarEstadisticaVenta(){
        
        try {
			this.listVentPorCliente = this.ventaService.obtenerVentasPorCliente();
			
			pieModel = new PieChartModel();  
	        
			for(ClienteDTO cli : this.listVentPorCliente){
		        pieModel.set(cli.getNombre() + " " + cli.getApellido(), cli.getCantVentas());  				
			}
	        
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public List<ProductoDTO> getListVentPorProducto() {
		return listVentPorProducto;
	}


	public void setListVentPorProducto(List<ProductoDTO> listVentPorProducto) {
		this.listVentPorProducto = listVentPorProducto;
	}
	public PieChartModel getPieModel() {
		return pieModel;
	}

	public void setPieModel(PieChartModel pieModel) {
		this.pieModel = pieModel;
	}

	public List<ClienteDTO> getListVentPorCliente() {
		return listVentPorCliente;
	}

	public void setListVentPorCliente(List<ClienteDTO> listVentPorCliente) {
		this.listVentPorCliente = listVentPorCliente;
	}

	public PieChartModel getPieModelProducto() {
		return pieModelProducto;
	}


	public void setPieModelProducto(PieChartModel pieModelProducto) {
		this.pieModelProducto = pieModelProducto;
	}


	public CartesianChartModel getBarraModel() {
		return barraModel;
	}

	public void setBarraModel(CartesianChartModel barraModel) {
		this.barraModel = barraModel;
	}	
}
