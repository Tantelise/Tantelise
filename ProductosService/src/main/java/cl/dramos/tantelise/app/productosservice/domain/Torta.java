package cl.dramos.tantelise.app.productosservice.domain;

import java.util.List;

import io.swagger.annotations.ApiModelProperty;

public class Torta {
	
    @ApiModelProperty(notes = "Nombre del tipo de torta")
	private String tipoTorta;
    @ApiModelProperty(notes = "Lista que especifica valores para distintas cantidades de personas")
	private List<DetallePersonas> detallePersonas;
    @ApiModelProperty(notes = "Lista que especifica servicios adicionales para la torta")
	private List<DetalleAdicional> detalleAdicional;
	
	public String getTipoTorta() {
		return tipoTorta;
	}
	public void setTipoTorta(String tipoTorta) {
		this.tipoTorta = tipoTorta;
	}
	public List<DetallePersonas> getDetallePersonas() {
		return detallePersonas;
	}
	public void setDetallePersonas(List<DetallePersonas> detallePersonas) {
		this.detallePersonas = detallePersonas;
	}
	public List<DetalleAdicional> getDetalleAdicional() {
		return detalleAdicional;
	}
	public void setDetalleAdicional(List<DetalleAdicional> detalleAdicional) {
		this.detalleAdicional = detalleAdicional;
	}
	
	

}
