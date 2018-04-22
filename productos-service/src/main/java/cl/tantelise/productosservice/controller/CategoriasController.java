package cl.tantelise.productosservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.tantelise.productosservice.categorias.Categoria;
import cl.tantelise.productosservice.service.CategoriaService;

@RestController
@RequestMapping(path="categorias-productos", produces ="application/json")
@CrossOrigin(origins = "http://localhost:4200")

public class CategoriasController {
	@Autowired
	private CategoriaService categoriaService;
	
	@GetMapping
	public List<Categoria> getCategoriaLista(){
		return this.categoriaService.buscarCategoriaLista();
	}
	
	@GetMapping(path="/{identificador}")
	public Optional<Categoria> getCategoriaPorId(@PathVariable String identificador){
		return this.categoriaService.buscarCategoriaPorID(identificador);
	}

	
	@DeleteMapping(path="/{identificador}")
	public boolean deleteCategoriaoPorId(@PathVariable String identificador){
		return this.categoriaService.eliminarCategoria(identificador);
	}
	
	@PutMapping(path="/{identificador}")
	public boolean actualizarCategoria(@PathVariable String identificador, @RequestBody Categoria categoria){
		return this.categoriaService.actualizarCategoria(identificador,categoria);
	}
	
	@PostMapping
	public boolean crearCategoria(@RequestBody Categoria categoria){
		return this.categoriaService.crearCategoria(categoria);
	}
}
