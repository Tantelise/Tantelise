package cl.tantelise.productosservice.categorias;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="categorias")
public class Categoria {

	
	@Id 
	private String id;
	private String nombreCategoria;
	private String descripcionCategoria;
	
	
	public Categoria() {
		
	}
	
	
	
	public Categoria(String id, String nombreCategoria, String descripcionCategoria) {
		super();
		this.id = id;
		this.nombreCategoria = nombreCategoria;
		this.descripcionCategoria = descripcionCategoria;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNombreCategoria() {
		return nombreCategoria;
	}
	public void setNombreCategoria(String nombreCategoria) {
		this.nombreCategoria = nombreCategoria;
	}
	public String getDescripcionCategoria() {
		return descripcionCategoria;
	}
	public void setDescripcionCategoria(String descripcionCategoria) {
		this.descripcionCategoria = descripcionCategoria;
	}
	
	
	
	
	
}
