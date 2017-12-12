package cl.dramos.tantelise.app.clientesservice.domain.respuestas;

public class RespuestaClientePUT {
	private String identificador;
	private boolean actualizado;

	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public boolean isActualizado() {
		return actualizado;
	}

	public void setActualizado(boolean actualizado) {
		this.actualizado = actualizado;
	}
}
