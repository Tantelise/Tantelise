package cl.dramos.tantelise.app.productosservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.dramos.tantelise.app.productosservice.service.DetalleAdicionalService;
import io.swagger.annotations.Api;

@RestController
@RequestMapping("adicionales")
@Api(value = "Api de servicios adicionales para productos", description = "Operaciones relacionadas a los servicios adicionales")

public class DetalleAdicionalController {
	@Autowired
	private DetalleAdicionalService detalleAdicionalService;

}
