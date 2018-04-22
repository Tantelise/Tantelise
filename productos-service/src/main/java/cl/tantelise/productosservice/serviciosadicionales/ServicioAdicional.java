package cl.tantelise.productosservice.serviciosadicionales;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "serviciosadicionales")
public class ServicioAdicional {
	
	@Id
	private String id;
	private String nombre;
	private String precio;
	private String condiciones;
	
	public ServicioAdicional() {
		
	}
	
	

	public ServicioAdicional(String id, String nombre, String precio, String condiciones) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
		this.condiciones = condiciones;
	}



	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPrecio() {
		return precio;
	}

	public void setPrecio(String precio) {
		this.precio = precio;
	}

	public String getCondiciones() {
		return condiciones;
	}

	public void setCondiciones(String condiciones) {
		this.condiciones = condiciones;
	}
	
	

}