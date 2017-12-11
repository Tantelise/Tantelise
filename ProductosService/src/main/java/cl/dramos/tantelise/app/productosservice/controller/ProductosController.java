package cl.dramos.tantelise.app.productosservice.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.dramos.tantelise.app.productosservice.domain.Producto;
import cl.dramos.tantelise.app.productosservice.domain.respuestas.RespuestaProductosServiceDELETE;
import cl.dramos.tantelise.app.productosservice.domain.respuestas.RespuestaProductosServiceGET;
import cl.dramos.tantelise.app.productosservice.domain.respuestas.RespuestaProductosServicePOST;
import cl.dramos.tantelise.app.productosservice.domain.respuestas.RespuestaProductosServicePUT;
import cl.dramos.tantelise.app.productosservice.service.ProductosService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(path = "productos",produces = "application/json")
@Api(value="Productos API")
public class ProductosController {
	
	@Autowired
	private ProductosService productosService;
	
	@ApiOperation(value = "Retorna una lista con todos los productos y sus estados")
	@GetMapping()
	public ResponseEntity<RespuestaProductosServiceGET> getProductos(){	
		return productosService.buscarProductoLista();
	}
	
	@ApiOperation(value="Crea un producto o lista de productos", consumes="application/json")
	@PostMapping(path="")
	public ResponseEntity<RespuestaProductosServicePOST> crearProducto(@RequestBody ArrayList<Producto> nuevoProducto) {
		return productosService.crearProductoLista(nuevoProducto);
	}
	
	@ApiOperation(value="Eliminar un producto por identificador")
	@DeleteMapping(path="/{identificador}")
	public ResponseEntity<RespuestaProductosServiceDELETE> eliminarProductoPorId(@PathVariable String identificador) {
		return productosService.eliminarProducto(identificador);
	}
	
	@ApiOperation(value="Actualizar un producto")
	@PutMapping(path="/{id}")
	public ResponseEntity<RespuestaProductosServicePUT> actualizarProductoPorId(@PathVariable String id,@RequestBody Producto productoPorActualizar) {
		return productosService.actualizarProducto(id, productoPorActualizar);
	}
}
