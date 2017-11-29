package cl.dramos.tantelise.app.productosservice.domain.respuestas;

import java.util.List;

import cl.dramos.tantelise.app.productosservice.domain.Producto;

public class RespuestaProductosServiceGET {
	
	List<Producto> productos;
	long cantidadResultados;
	
	public List<Producto> getProductos() {
		return productos;
	}
	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}
	public long getCantidadResultados() {
		return cantidadResultados;
	}
	public void setCantidadResultados(long cantidadResultados) {
		this.cantidadResultados = cantidadResultados;
	}
	
	public void setDatos(List<Producto> productos) {
		this.productos = productos;
		this.cantidadResultados = productos.size();
	}

	
	
}
