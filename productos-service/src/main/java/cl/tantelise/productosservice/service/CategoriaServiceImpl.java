package cl.tantelise.productosservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

import cl.tantelise.productosservice.categorias.Categoria;
import cl.tantelise.productosservice.categorias.CategoriaRepositorio;

@Service
public class CategoriaServiceImpl implements CategoriaService{
	@Autowired
	private CategoriaRepositorio categoriaRepositorio;

	private static final Logger LOG = LoggerFactory.getLogger(ProductosService.class);
	@Override
	public List<Categoria> buscarCategoriaLista() {
		LOG.trace("buscarCategoriaLista");
		List<Categoria> categoriaLista = new ArrayList<Categoria>();
		categoriaLista = this.categoriaRepositorio.findAll();
		LOG.trace("categoria encontrados: ");
		LOG.trace(new Gson().toJson(categoriaLista));
		return categoriaLista;
	}

	@Override
	public Optional<Categoria> buscarCategoriaPorID(String id) {
		LOG.trace("buscarCategoriaPorID");
		Optional<Categoria> categoria = this.categoriaRepositorio.findById(id);
		LOG.trace("Producto encontrado ");
		LOG.trace(new Gson().toJson(categoria));
		return categoria;
	}

	@Override
	public boolean actualizarCategoria(String id, Categoria categoria) {
		LOG.trace("actualizarCategoria");
		LOG.trace("actualizando categoria, verificando categoria: " +id);
		LOG.trace(new Gson().toJson(categoria));

		boolean isUpdated = false;

		try {
			if(categoria.getId().equals(id)) {
				this.buscarCategoriaPorID(id).get();
				this.categoriaRepositorio.save(categoria);
				LOG.trace("actualizado OK");
				isUpdated = true;
			}else {
				LOG.error(" No coinciden los IDs de categoria");
			}



		} catch (NoSuchElementException e) {
			LOG.trace("actualizado No OK");
			LOG.error("No se ha podido actualizar  categoria indicado");
		}
		return isUpdated;
	}

	@Override
	public boolean eliminarCategoria(String id) {
		LOG.trace("eliminarCategoria");
		LOG.trace("Eliminando categoria, verificando ");

		boolean isDeleted = false;

		try {
			this.buscarCategoriaPorID(id).get();
			this.categoriaRepositorio.deleteById(id);
			LOG.trace("Eliminado OK");
			isDeleted = true;

		} catch (NoSuchElementException e) {
			LOG.trace("Eliminado No OK");
			LOG.error("No se ha podido eleiminar  categoria indicado");
		}
		return isDeleted;
	}

	@Override
	public boolean crearCategoria(Categoria categoria) {
		LOG.trace("crearCategoria");
		LOG.trace("crear categoria: ");
		LOG.trace(new Gson().toJson(categoria));

		boolean isCreado = false;

		try {
			this.categoriaRepositorio.insert(categoria);
			LOG.trace("creado OK");
			isCreado = true;

		} catch (Exception e) {
			LOG.trace("creado No OK");
			LOG.error("No se ha podido crear la categoria indicado");
		}
		return isCreado;
	}

}
