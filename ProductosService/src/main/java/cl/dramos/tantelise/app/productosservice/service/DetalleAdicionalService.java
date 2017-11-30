package cl.dramos.tantelise.app.productosservice.service;

import org.springframework.http.ResponseEntity;

import cl.dramos.tantelise.app.productosservice.domain.DetalleAdicional;
import cl.dramos.tantelise.app.productosservice.domain.respuestas.RespuestaDetalleAdicionalServiceDELETE;
import cl.dramos.tantelise.app.productosservice.domain.respuestas.RespuestaDetalleAdicionalServiceGET;
import cl.dramos.tantelise.app.productosservice.domain.respuestas.RespuestaDetalleAdicionalServicePOST;
import cl.dramos.tantelise.app.productosservice.domain.respuestas.RespuestaDetalleAdicionalServicePUT;

public interface DetalleAdicionalService {
	
	public ResponseEntity<RespuestaDetalleAdicionalServiceGET> obtenerDetalleAdicionalLista();
	public ResponseEntity<RespuestaDetalleAdicionalServiceGET> obtenerDetalleAdicionalPorID(String id);
	public ResponseEntity<RespuestaDetalleAdicionalServiceDELETE> eliminarDetalleAdicional(String id);
	public ResponseEntity<RespuestaDetalleAdicionalServicePUT> actualizarDetalleAdicional(DetalleAdicional detalleAdicional);
	public ResponseEntity<RespuestaDetalleAdicionalServicePOST> crearDetalleAdicional(DetalleAdicional detalleAdicional);



}
