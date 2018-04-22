package cl.tantelise.productosservice.service;

import java.util.List;
import java.util.Optional;

import cl.tantelise.productosservice.productos.Producto;

public interface ProductosService {
	
	public List<Producto> buscarProductoLista();
	public Optional<Producto> buscarProductoPorID(String id);
	public boolean actualizarProducto (String id,Producto producto);
	public boolean eliminarProducto (String id);
	public boolean crearProducto (Producto producto);

	


}
