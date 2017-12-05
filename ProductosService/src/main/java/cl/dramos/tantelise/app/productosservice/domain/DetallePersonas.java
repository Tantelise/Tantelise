package cl.dramos.tantelise.app.productosservice.domain;

import io.swagger.annotations.ApiModelProperty;

public class DetallePersonas {
	
    @ApiModelProperty(notes = "Número de personas")
	public int cantidadPersonas;
    @ApiModelProperty(notes = "Precio especifico para esta cantidad de personas")
	public float precioCantidad;
    
    public DetallePersonas(int cantidadPersonas, float precioCantidad) {
    	this.cantidadPersonas = cantidadPersonas;
    	this.precioCantidad = precioCantidad;
    }
    
    public DetallePersonas() {
    	
    }
	
	public int getCantidadPersonas() {
		return cantidadPersonas;
	}
	public void setCantidadPersonas(int cantidadPersonas) {
		this.cantidadPersonas = cantidadPersonas;
	}
	public float getPrecioCantidad() {
		return precioCantidad;
	}
	public void setPrecioCantidad(float precioCantidad) {
		this.precioCantidad = precioCantidad;
	}
	
	

}
