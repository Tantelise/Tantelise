package cl.dramos.tantelise.app.serviciosservice.service;

import org.springframework.http.ResponseEntity;

import cl.dramos.tantelise.app.serviciosservice.domain.Servicio;
import cl.dramos.tantelise.app.serviciosservice.domain.respuestas.RespuestaServiciosDELETE;
import cl.dramos.tantelise.app.serviciosservice.domain.respuestas.RespuestaServiciosGET;
import cl.dramos.tantelise.app.serviciosservice.domain.respuestas.RespuestaServiciosPOST;
import cl.dramos.tantelise.app.serviciosservice.domain.respuestas.RespuestaServiciosPUT;

public interface ServicioService {

	public ResponseEntity<RespuestaServiciosGET> obtenerServicios();
	public ResponseEntity<RespuestaServiciosGET> obtenerServicioPorId(String id);
	public ResponseEntity<RespuestaServiciosPOST> crearServicio(Servicio servicio);
	public ResponseEntity<RespuestaServiciosPUT> actualizarServicio(Servicio servicio);
	public ResponseEntity<RespuestaServiciosDELETE> eliminarServicioPorId(String id);
}


