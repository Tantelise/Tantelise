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


import cl.tantelise.productosservice.service.ServicioAdicionalService;
import cl.tantelise.productosservice.serviciosadicionales.ServicioAdicional;

@RestController
@RequestMapping(path="servicios-adicionales", produces ="application/json")
@CrossOrigin(origins = "http://localhost:4200")

public class ServiciosAdicionalesController {
	@Autowired
	private ServicioAdicionalService serviciosAdicionalesService;
	
	@GetMapping
	public List<ServicioAdicional> getServiciosAdicionales(){
		return this.serviciosAdicionalesService.buscarServicioAdicionalLista();
	}
	
	@GetMapping(path="/{identificador}")
	public Optional<ServicioAdicional> getProductoPorId(@PathVariable String identificador){
		return this.serviciosAdicionalesService.buscarServicioAdicionalPorID(identificador);
	}

	
	@DeleteMapping(path="/{identificador}")
	public boolean deleteServicioAdicionalPorId(@PathVariable String identificador){
		return this.serviciosAdicionalesService.eliminarServicioAdicional(identificador);
	}
	
	@PutMapping(path="/{identificador}")
	public boolean actualizarServicioAdicional(@PathVariable String identificador, @RequestBody ServicioAdicional servicioAdicional){
		return this.serviciosAdicionalesService.actualizarServicioAdicional(identificador,servicioAdicional);
	}
	
	@PostMapping
	public boolean crearServicioAdicional(@RequestBody ServicioAdicional servicioAdicional){
		return this.serviciosAdicionalesService.crearServicioAdicional(servicioAdicional);
	}
}
