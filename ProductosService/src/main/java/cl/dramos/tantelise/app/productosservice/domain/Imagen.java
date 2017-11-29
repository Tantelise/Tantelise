package cl.dramos.tantelise.app.productosservice.domain;

import io.swagger.annotations.ApiModelProperty;

public class Imagen {

    @ApiModelProperty(notes = "URI de la imágen correspondiente")
	private String ruta;
    @ApiModelProperty(notes = "Nombre de la imágen")
	private String nombre;
    @ApiModelProperty(notes = "Indicador para determinar si corresponde a la foto de portada del producto")
	private boolean esPortada;
    
    public Imagen() {
    	
    }
    public Imagen(String ruta, String nombre, boolean esPortada) {
    	this.ruta = ruta;
    	this.nombre = nombre;
    	this.esPortada = esPortada;
    }
	
	public String getRuta() {
		return ruta;
	}
	public void setRuta(String ruta) {
		this.ruta = ruta;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public boolean isEsPortada() {
		return esPortada;
	}
	public void setEsPortada(boolean esPortada) {
		this.esPortada = esPortada;
	}
	
	
}
