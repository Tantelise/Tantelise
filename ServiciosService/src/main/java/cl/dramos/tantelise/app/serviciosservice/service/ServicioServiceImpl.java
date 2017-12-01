package cl.dramos.tantelise.app.serviciosservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import cl.dramos.tantelise.app.serviciosservice.domain.Servicio;
import cl.dramos.tantelise.app.serviciosservice.domain.ServicioRepositorio;
import cl.dramos.tantelise.app.serviciosservice.domain.respuestas.RespuestaServiciosDELETE;
import cl.dramos.tantelise.app.serviciosservice.domain.respuestas.RespuestaServiciosGET;
import cl.dramos.tantelise.app.serviciosservice.domain.respuestas.RespuestaServiciosPOST;
import cl.dramos.tantelise.app.serviciosservice.domain.respuestas.RespuestaServiciosPUT;

@Service
public class ServicioServiceImpl implements ServicioService {
	
	@Autowired
	private ServicioRepositorio servicioRepositorio;

	@Override
	public ResponseEntity<RespuestaServiciosGET> obtenerServicios() {
		return null;
	}

	@Override
	public ResponseEntity<RespuestaServiciosGET> obtenerServicioPorId(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<RespuestaServiciosGET> obtenerServicioPorNombre(String nombre) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<RespuestaServiciosPOST> crearServicio(Servicio servicio) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<RespuestaServiciosPUT> actualizarServicio(Servicio servicio) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<RespuestaServiciosDELETE> eliminarServicioPorId(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
