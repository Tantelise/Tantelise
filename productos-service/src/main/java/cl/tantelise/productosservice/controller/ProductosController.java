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

import cl.tantelise.productosservice.productos.Producto;
import cl.tantelise.productosservice.service.ProductosService;

@RestController
@RequestMapping(path="productos", produces ="application/json")
@CrossOrigin(origins = "http://localhost:4200")

public class ProductosController {
	
	@Autowired
	private ProductosService productoService;
	
	@GetMapping
	public List<Producto> getProductos(){
		return this.productoService.buscarProductoLista();
	}
	
	@GetMapping(path="/{identificador}")
	public Optional<Producto> getProductoPorId(@PathVariable String identificador){
		return this.productoService.buscarProductoPorID(identificador);
	}

	
	@DeleteMapping(path="/{identificador}")
	public boolean deleteProductoPorId(@PathVariable String identificador){
		return this.productoService.eliminarProducto(identificador);
	}
	
	@PutMapping(path="/{identificador}")
	public boolean actualizarProducto(@PathVariable String identificador, @RequestBody Producto producto){
		return this.productoService.actualizarProducto(identificador,producto);
	}
	
	@PostMapping
	public boolean crearPropducto(@RequestBody Producto producto){
		return this.productoService.crearProducto(producto);
	}
}
