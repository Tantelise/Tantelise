package cl.dramos.tantelise.app.clientesservice.domain.respuestas;

public class RespuestaClienteDELETE {
	
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
