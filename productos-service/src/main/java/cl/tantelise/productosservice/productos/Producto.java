package cl.tantelise.productosservice.productos;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "productos")
public class Producto {
	
	
	@Id
	private String id;
	
	private String nombreProducto;
	private String descripcionProducto;
	private String categoriaProducto;
	private String imagenPortada;
	private String fechaIngreso;
	private String fechaModificacion;
	private String estado;
	private Object detalleProducto;
	
	
	public Producto() {
		
	}

	

	public Producto(String id, String nombreProducto, String descripcionProducto, String categoriaProducto,
			String imagenPortada, String fechaIngreso, String fechaModificacion, String estado,
			Object detalleProducto) {
		super();
		this.id = id;
		this.nombreProducto = nombreProducto;
		this.descripcionProducto = descripcionProducto;
		this.categoriaProducto = categoriaProducto;
		this.imagenPortada = imagenPortada;
		this.fechaIngreso = fechaIngreso;
		this.fechaModificacion = fechaModificacion;
		this.estado = estado;
		this.detalleProducto = detalleProducto;
	}




	public Object getDetalleProducto() {
		return detalleProducto;
	}




	public void setDetalleProducto(Object detalleProducto) {
		this.detalleProducto = detalleProducto;
	}




	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNombreProducto() {
		return nombreProducto;
	}
	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}
	public String getDescripcionProducto() {
		return descripcionProducto;
	}
	public void setDescripcionProducto(String descripcionProducto) {
		this.descripcionProducto = descripcionProducto;
	}

	public String getCategoriaProducto() {
		return categoriaProducto;
	}
	public void setCategoriaProducto(String categoriaProducto) {
		this.categoriaProducto = categoriaProducto;
	}
	public String getImagenPortada() {
		return imagenPortada;
	}
	public void setImagenPortada(String imagenPortada) {
		this.imagenPortada = imagenPortada;
	}
	public String getFechaIngreso() {
		return fechaIngreso;
	}
	public void setFechaIngreso(String fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
	public String getFechaModificacion() {
		return fechaModificacion;
	}
	public void setFechaModificacion(String fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
	
	

}
