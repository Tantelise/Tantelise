package cl.dramos.tantelise.app.productosservice.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import io.swagger.annotations.ApiModelProperty;

@Document(collection = "servicios_adicionales")
public class DetalleAdicional {
	
	@Id
	@ApiModelProperty(notes = "Identificador único de cada servicio adicional")
	private String id;

	@ApiModelProperty(notes = "Tipo de servicio adicional")
	private String nombreAdicional;
    @ApiModelProperty(notes = "Restricciones u observaciones al servicio adicional")
	private String consideraciones;
    @ApiModelProperty(notes = "Precio por servicio adicional")
    
	private float precioAdicional;
    
    public DetalleAdicional(String nombreAdicional, String consideraciones, float precioAdicional) {
    	this.nombreAdicional = nombreAdicional;
    	this.consideraciones = consideraciones;
    	this.precioAdicional = precioAdicional;
    }
    
    public DetalleAdicional() {
    	
    }
	
	public String getNombreAdicional() {
		return nombreAdicional;
	}
	public void setNombreAdicional(String nombreAdicional) {
		this.nombreAdicional = nombreAdicional;
	}
	public String getConsideraciones() {
		return consideraciones;
	}
	public void setConsideraciones(String consideraciones) {
		this.consideraciones = consideraciones;
	}
	public float getPrecioAdicional() {
		return precioAdicional;
	}
	public void setPrecioAdicional(float precioAdicional) {
		this.precioAdicional = precioAdicional;
	}
    public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
