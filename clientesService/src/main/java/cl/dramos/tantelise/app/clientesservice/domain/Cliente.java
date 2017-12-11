package cl.dramos.tantelise.app.clientesservice.domain;

import java.util.ArrayList;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "clientes")
public class Cliente {

	@Id
	private String id;
	private String nombre;
	private String apellido;
	private String correo;
	private String numeroMovil;
	private String numeroFijo;
	private ArrayList<Direccion> direcciones;
	private ArrayList<FechaImportante> fechasImportantes;

	public Cliente() {

	}

	public Cliente(String id, String nombre, String apellido, String correo, String numeroMovil, String numeroFijo) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.correo = correo;
		this.numeroMovil = numeroMovil;
		this.numeroFijo = numeroFijo;
	}
	

	public Cliente(String id, String nombre, String apellido, String correo, String numeroMovil, String numeroFijo,
			ArrayList<Direccion> direcciones, ArrayList<FechaImportante> fechasImportantes) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.correo = correo;
		this.numeroMovil = numeroMovil;
		this.numeroFijo = numeroFijo;
		this.direcciones = direcciones;
		this.fechasImportantes = fechasImportantes;
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

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getNumeroMovil() {
		return numeroMovil;
	}

	public void setNumeroMovil(String numeroMovil) {
		this.numeroMovil = numeroMovil;
	}

	public String getNumeroFijo() {
		return numeroFijo;
	}

	public void setNumeroFijo(String numeroFijo) {
		this.numeroFijo = numeroFijo;
	}

	public ArrayList<Direccion> getDirecciones() {
		return direcciones;
	}

	public void setDirecciones(ArrayList<Direccion> direcciones) {
		this.direcciones = direcciones;
	}

	public ArrayList<FechaImportante> getFechasImportantes() {
		return fechasImportantes;
	}

	public void setFechasImportantes(ArrayList<FechaImportante> fechasImportantes) {
		this.fechasImportantes = fechasImportantes;
	}

	
	
}
