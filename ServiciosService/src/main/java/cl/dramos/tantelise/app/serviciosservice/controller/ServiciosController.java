package cl.dramos.tantelise.app.serviciosservice.controller;

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

import cl.dramos.tantelise.app.serviciosservice.domain.Servicio;
import cl.dramos.tantelise.app.serviciosservice.domain.respuestas.RespuestaServiciosDELETE;
import cl.dramos.tantelise.app.serviciosservice.domain.respuestas.RespuestaServiciosGET;
import cl.dramos.tantelise.app.serviciosservice.domain.respuestas.RespuestaServiciosPOST;
import cl.dramos.tantelise.app.serviciosservice.domain.respuestas.RespuestaServiciosPUT;
import cl.dramos.tantelise.app.serviciosservice.service.ServicioService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(path="servicios", produces="application/json")
@Api(value = "Api para servicios de banquetería tantelise")
public class ServiciosController {
	
	@Autowired
	private ServicioService serviciosService;
	
	@ApiOperation(value = "Retorna la lista de servicios disponibles")
	@GetMapping("")
	public ResponseEntity<RespuestaServiciosGET> obtenerServicios(){
		return serviciosService.obtenerServicios();
	}
	
	@ApiOperation(value = "Retorna la lista de servicios disponibles, segíun el id")
	@GetMapping("/{identificador}")
	public ResponseEntity<RespuestaServiciosGET> obtenerServicioPorId(@PathVariable String id){
		return serviciosService.obtenerServicioPorId(id);
	}
	
	@ApiOperation(value = "Crea un servicio de banquetería")
	@PostMapping("")
	public ResponseEntity<RespuestaServiciosPOST> crearServicio(@RequestBody Servicio servicio){
		return serviciosService.crearServicio(servicio);
	}
	
	@ApiOperation(value = "Actualiza un servicio de banquetería")
	@PutMapping("/{identificador}")
	public ResponseEntity<RespuestaServiciosPUT> actualizarServicio(@PathVariable String id, @RequestBody Servicio servicio){
		return serviciosService.actualizarServicio(servicio);
	}
	
	@ApiOperation(value="Elimina un servicio de banquetería, según identificador")
	@DeleteMapping("/{identificador}")
	public ResponseEntity<RespuestaServiciosDELETE> eliminarServicioPorId(@PathVariable String id){
		return serviciosService.eliminarServicioPorId(id);
	}

}
