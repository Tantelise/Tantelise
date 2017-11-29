package cl.dramos.tantelise.app.productosservice.domain.respuestas;

public class RespuestaProductosServicePUT {
	
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
