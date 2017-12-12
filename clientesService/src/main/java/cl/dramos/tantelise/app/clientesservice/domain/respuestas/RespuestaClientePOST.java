package cl.dramos.tantelise.app.clientesservice.domain.respuestas;

import java.util.ArrayList;

public class RespuestaClientePOST {
	private boolean creado;
	private long cantidad;
	private ArrayList<String> identificadores;

	public RespuestaClientePOST() {
		identificadores = new ArrayList<>();
	}

	public boolean isCreado() {
		return creado;
	}

	public void setCreado(boolean creado) {
		this.creado = creado;
	}

	public long getCantidad() {
		return cantidad;
	}

	public void setCantidad(long cantidad) {
		this.cantidad = cantidad;
	}

	public ArrayList<String> getIdentificadores() {
		return identificadores;
	}

	public void setIdentificadores(ArrayList<String> identificadores) {
		this.identificadores = identificadores;
	}

}
