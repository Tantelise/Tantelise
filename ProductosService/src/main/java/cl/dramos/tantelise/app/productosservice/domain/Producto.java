package cl.dramos.tantelise.app.productosservice.domain;

import java.util.List;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import io.swagger.annotations.ApiModelProperty;

@Document(collection = "productos")
public class Producto {

	@Id
	@ApiModelProperty(notes = "Identificador único de cada producto")
	private String id;

	@NotEmpty(message= "El nombre del producto no puede estar vacío")
	@ApiModelProperty(notes = "Nombre del producto")
	private String nombreProducto;

	@NotEmpty(message= "Se debe ingresar una descripción")
	@ApiModelProperty(notes = "Descripción del producto")
	private String descripcion;

	@NotEmpty(message= "Se debe ingresar la únidad de venta")
	@ApiModelProperty(notes = "Forma o medida en la que se vende el producto")
	private String unidadVenta;

	@NotEmpty(message= "Se debe indicar el precio por únidad")
	@ApiModelProperty(notes = "Precio por únidad")
	private float precioUnidad;
	
	@NotEmpty(message= "Se debe indicar la categoría del producto")
	@ApiModelProperty(notes = "Categoria del producto")
	private String categoriaProducto;
	
	@ApiModelProperty(notes = "Información adicional al producto, sólo si corresponde a categoria torta")
	private Torta torta;
	
	@ApiModelProperty(notes = "Lista de imagenes asociadas al producto")
	private List<Imagen> imagen;
	
	@NotEmpty(message= "La fecha de ingreso no puede estar vacía")
	@ApiModelProperty(notes = "Fecha en la que se ingresó el producto al sistema")
	private String fechaIngreso;
	
	@ApiModelProperty(notes = "Fecha de la última modificación al producto")
	private String fechaUltimaModificacion;
	
	@NotEmpty(message= "Se debe indicar un estado")
	@ApiModelProperty(notes = "Indica el estado en el que se encuentra el producto")
	private String estado;

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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getUnidadVenta() {
		return unidadVenta;
	}

	public void setUnidadVenta(String unidadVenta) {
		this.unidadVenta = unidadVenta;
	}

	public float getPrecioUnidad() {
		return precioUnidad;
	}

	public void setPrecioUnidad(float precioUnidad) {
		this.precioUnidad = precioUnidad;
	}

	public String getCategoriaProducto() {
		return categoriaProducto;
	}

	public void setCategoriaProducto(String categoriaProducto) {
		this.categoriaProducto = categoriaProducto;
	}

	public Torta getTorta() {
		return torta;
	}

	public void setTorta(Torta torta) {
		this.torta = torta;
	}

	public List<Imagen> getImagen() {
		return imagen;
	}

	public void setImagen(List<Imagen> imagen) {
		this.imagen = imagen;
	}

	public String getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(String fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public String getFechaUltimaModificacion() {
		return fechaUltimaModificacion;
	}

	public void setFechaUltimaModificacion(String fechaUltimaModificacion) {
		this.fechaUltimaModificacion = fechaUltimaModificacion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Producto(String id, String nombreProducto, String descripcion, String unidadVenta, float precioUnidad,
			String categoriaProducto, Torta torta, List<Imagen> imagen, String fechaIngreso,
			String fechaUltimaModificacion, String estado) {
		super();
		this.id = id;
		this.nombreProducto = nombreProducto;
		this.descripcion = descripcion;
		this.unidadVenta = unidadVenta;
		this.precioUnidad = precioUnidad;
		this.categoriaProducto = categoriaProducto;
		this.torta = torta;
		this.imagen = imagen;
		this.fechaIngreso = fechaIngreso;
		this.fechaUltimaModificacion = fechaUltimaModificacion;
		this.estado = estado;
	}

	public Producto() {
		// TODO Auto-generated constructor stub
	}
	
	

}
