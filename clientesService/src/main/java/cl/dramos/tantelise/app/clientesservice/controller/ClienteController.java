package cl.dramos.tantelise.app.clientesservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import cl.dramos.tantelise.app.clientesservice.service.ClienteService;

@RestController
public class ClienteController {
	
	@Autowired
	private ClienteService servicioCliente;

}
