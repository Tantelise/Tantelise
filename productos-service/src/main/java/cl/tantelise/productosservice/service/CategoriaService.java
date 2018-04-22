package cl.tantelise.productosservice.service;

import java.util.List;
import java.util.Optional;

import cl.tantelise.productosservice.categorias.Categoria;


public interface CategoriaService {
	public List<Categoria> buscarCategoriaLista();
	public Optional<Categoria> buscarCategoriaPorID(String id);
	public boolean actualizarCategoria (String id,Categoria categoria);
	public boolean eliminarCategoria (String id);
	public boolean crearCategoria (Categoria categoria);
}
