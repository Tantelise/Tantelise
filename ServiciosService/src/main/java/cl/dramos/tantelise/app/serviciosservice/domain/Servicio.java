package cl.dramos.tantelise.app.serviciosservice.domain;

import java.util.ArrayList;

public class Servicio {

	private String id;
	private String nombreServicio;
	private String descripcionServicio;
	private String tiempoAnticipacionSugerido;
	private String consideracionesGenerales;
	private int personasMinimasSugeridas;
	
	private ArrayList<Imagen> imagenes;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombreServicio() {
		return nombreServicio;
	}

	public void setNombreServicio(String nombreServicio) {
		this.nombreServicio = nombreServicio;
	}

	public String getDescripcionServicio() {
		return descripcionServicio;
	}

	public void setDescripcionServicio(String descripcionServicio) {
		this.descripcionServicio = descripcionServicio;
	}

	public String getTiempoAnticipacionSugerido() {
		return tiempoAnticipacionSugerido;
	}

	public void setTiempoAnticipacionSugerido(String tiempoAnticipacionSugerido) {
		this.tiempoAnticipacionSugerido = tiempoAnticipacionSugerido;
	}

	public String getConsideracionesGenerales() {
		return consideracionesGenerales;
	}

	public void setConsideracionesGenerales(String consideracionesGenerales) {
		this.consideracionesGenerales = consideracionesGenerales;
	}

	public int getPersonasMinimasSugeridas() {
		return personasMinimasSugeridas;
	}

	public void setPersonasMinimasSugeridas(int personasMinimasSugeridas) {
		this.personasMinimasSugeridas = personasMinimasSugeridas;
	}

	public ArrayList<Imagen> getImagenes() {
		return imagenes;
	}

	public void setImagenes(ArrayList<Imagen> imagenes) {
		this.imagenes = imagenes;
	}

}
