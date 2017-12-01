package cl.dramos.tantelise.app.productosservice.controller;

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

import cl.dramos.tantelise.app.productosservice.domain.DetalleAdicional;
import cl.dramos.tantelise.app.productosservice.domain.respuestas.RespuestaDetalleAdicionalServiceDELETE;
import cl.dramos.tantelise.app.productosservice.domain.respuestas.RespuestaDetalleAdicionalServiceGET;
import cl.dramos.tantelise.app.productosservice.domain.respuestas.RespuestaDetalleAdicionalServicePOST;
import cl.dramos.tantelise.app.productosservice.domain.respuestas.RespuestaDetalleAdicionalServicePUT;

import cl.dramos.tantelise.app.productosservice.service.DetalleAdicionalService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(path ="adicionales", produces = "application/json")
@Api(value = "Api de servicios adicionales para productos", description = "Operaciones relacionadas a los servicios adicionales")

public class DetalleAdicionalController {
	@Autowired
	private DetalleAdicionalService detalleAdicionalService;

	@ApiOperation(value = "Retorna una lista con todos los servicios adicionales")
	@GetMapping()
	public ResponseEntity<RespuestaDetalleAdicionalServiceGET> getDetalleAdicionalLista(){	
		return detalleAdicionalService.obtenerDetalleAdicionalLista();
	}
	
	@ApiOperation(value = "Retorna un servicio adicional según el id indicado")
	@GetMapping("{identificador}")
	public ResponseEntity<RespuestaDetalleAdicionalServiceGET> getDetalleAdicionalPorId(@PathVariable String identificador){
		return detalleAdicionalService.obtenerDetalleAdicionalPorID(identificador);
	}
	
	@ApiOperation(value="Eliminar un servicio adicional por identificador")
	@DeleteMapping(path="/{identificador}")
	public ResponseEntity<RespuestaDetalleAdicionalServiceDELETE> eliminarDetalleAdicionalPorId(@PathVariable String identificador) {
		return detalleAdicionalService.eliminarDetalleAdicional(identificador);
	}
	
	@ApiOperation(value="Actualizar un servicio adicional")
	@PutMapping(path="{id}")
	public ResponseEntity<RespuestaDetalleAdicionalServicePUT> actualizarProductoPorId(@RequestBody DetalleAdicional detalleAdicional) {
		return detalleAdicionalService.actualizarDetalleAdicional(detalleAdicional);
	}
	
	@ApiOperation(value="Crea un servicio adicional")
	@PostMapping(path="")
	public ResponseEntity<RespuestaDetalleAdicionalServicePOST> crearProducto(@RequestBody DetalleAdicional detalleAdicional) {
		return detalleAdicionalService.crearDetalleAdicional(detalleAdicional);
	}
}
