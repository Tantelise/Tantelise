package cl.dramos.tantelise.app.productosservice.domain.respuestas;

import java.util.List;

import cl.dramos.tantelise.app.productosservice.domain.DetalleAdicional;

public class RespuestaDetalleAdicionalServiceGET {
	
	private List<DetalleAdicional> detalleAdicionalLista;
	private int cantidad;
	
	public List<DetalleAdicional> getDetalleAdicionalLista() {
		return detalleAdicionalLista;
	}
	public void setDetalleAdicionalLista(List<DetalleAdicional> detalleAdicionalLista) {
		this.detalleAdicionalLista = detalleAdicionalLista;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public void setDatos(List<DetalleAdicional> detalleAdicionalLista) {
		this.detalleAdicionalLista = detalleAdicionalLista;
		this.cantidad = detalleAdicionalLista.size();
	}

}
