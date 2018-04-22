package cl.tantelise.productosservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cl.tantelise.productosservice.productos.Producto;
import cl.tantelise.productosservice.productos.ProductosRepositorio;

@Service
public class ProductosServiceImpl implements ProductosService {

	@Autowired
	private ProductosRepositorio productosRepositorio;

	private static final Logger LOG = LoggerFactory.getLogger(ProductosService.class);

	@Override
	public List<Producto> buscarProductoLista() {
		LOG.trace("buscarProductoLista");
		List<Producto> productoLista = new ArrayList<Producto>();
		productoLista = this.productosRepositorio.findAll();
		LOG.trace("Productos encontrados: ");
		LOG.trace(new Gson().toJson(productoLista));
		return productoLista;
	}

	@Override
	public Optional<Producto> buscarProductoPorID(String id) {
		LOG.trace("buscarProductoPorID");
		Optional<Producto> producto = this.productosRepositorio.findById(id);
		LOG.trace("Producto encontrado ");
		LOG.trace(new Gson().toJson(producto));
		return producto;
	}

	@Override
	public boolean actualizarProducto(String id, Producto producto) {
		LOG.trace("actualizarProducto");
		LOG.trace("actualizando producto, verificando producto: " +id);
		LOG.trace(new Gson().toJson(producto));

		boolean isUpdated = false;

		try {
			if(producto.getId().equals(id)) {
				this.buscarProductoPorID(id).get();
				this.productosRepositorio.save(producto);
				LOG.trace("actualizado OK");
				isUpdated = true;
			}else {
				LOG.error(" No coinciden los IDs de productos");
			}



		} catch (NoSuchElementException e) {
			LOG.trace("actualizado No OK");
			LOG.error("No se ha podido actualizar el producto indicado");
		}
		return isUpdated;
	}

	@Override
	public boolean eliminarProducto(String id) {
		LOG.trace("eliminarProducto");
		LOG.trace("Eliminando producto, verificando ");

		boolean isDeleted = false;

		try {
			this.buscarProductoPorID(id).get();
			this.productosRepositorio.deleteById(id);
			LOG.trace("Eliminado OK");
			isDeleted = true;

		} catch (NoSuchElementException e) {
			LOG.trace("Eliminado No OK");
			LOG.error("No se ha podido eleiminar el producto indicado");
		}
		return isDeleted;

	}

	@Override
	public boolean crearProducto(Producto producto) {
		LOG.trace("crearProducto");
		LOG.trace("crear producto: ");
		LOG.trace(new Gson().toJson(producto));

		boolean isCreado = false;

		try {
			this.productosRepositorio.insert(producto);
			LOG.trace("creado OK");
			isCreado = true;

		} catch (Exception e) {
			LOG.trace("creado No OK");
			LOG.error("No se ha podido crear el producto indicado");
		}
		return isCreado;
	}

}
