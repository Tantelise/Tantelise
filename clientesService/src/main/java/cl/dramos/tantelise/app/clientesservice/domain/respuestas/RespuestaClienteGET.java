package cl.dramos.tantelise.app.clientesservice.domain.respuestas;

import java.util.Arrays;
import java.util.List;

import cl.dramos.tantelise.app.clientesservice.domain.Cliente;

public class RespuestaClienteGET {
	
	private List<Cliente> datos;
	private int cantidad;

	public void setDatos(List<Cliente> datos) {
		this.datos = datos;
		this.cantidad = datos.size();
		
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public List<Cliente> getDatos() {
		return datos;
	}

	public void setDatos(Cliente cliente) {
		this.datos = Arrays.asList(cliente);
		this.cantidad = 1;
		
	}

}
