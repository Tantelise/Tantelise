package cl.dramos.tantelise.app.productosservice.domain.respuestas;


public class RespuestaProductosServiceDELETE {

	private String identificador;
	private boolean eliminado;
	
	public String getIdentificador() {
		return identificador;
	}
	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}
	public boolean isEliminado() {
		return eliminado;
	}
	public void setEliminado(boolean eliminado) {
		this.eliminado = eliminado;
	}

}
