package cl.dramos.tantelise.app.serviciosservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
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
	private HttpHeaders headers;
	
	public ServicioServiceImpl() {
		headers = new HttpHeaders();
		headers.add("Content-Type", "application/json; charset=UTF-8");
	}

	@Override
	public ResponseEntity<RespuestaServiciosGET> obtenerServicios() {
		RespuestaServiciosGET respuestaGET = new RespuestaServiciosGET();
		respuestaGET.setDatos(servicioRepositorio.findAll());
		return new ResponseEntity<RespuestaServiciosGET>(respuestaGET,headers,HttpStatus.OK);
	}

	@Override
	public ResponseEntity<RespuestaServiciosGET> obtenerServicioPorId(String id) {
		RespuestaServiciosGET respuestaGET = new RespuestaServiciosGET();
		respuestaGET.setDatos(servicioRepositorio.findById(id));
		return new ResponseEntity<RespuestaServiciosGET>(respuestaGET,headers,HttpStatus.OK);
	}



	@Override
	public ResponseEntity<RespuestaServiciosPUT> actualizarServicio(Servicio servicio) {
		RespuestaServiciosPUT body = new RespuestaServiciosPUT();
		body.setIdentificador(servicio.getId());
		body.setActualizado(false);
		
		Servicio resultado = servicioRepositorio.save(servicio);
		if (resultado.equals(servicio)) {
			body.setActualizado(true);
			return new ResponseEntity<RespuestaServiciosPUT>(body,headers,HttpStatus.OK);
		}else if(resultado.equals(null)){
			return new ResponseEntity<RespuestaServiciosPUT>(body,headers,HttpStatus.INTERNAL_SERVER_ERROR);
		}else {
			return new ResponseEntity<RespuestaServiciosPUT>(body,headers,HttpStatus.NO_CONTENT);
		}
	}

	@Override
	public ResponseEntity<RespuestaServiciosDELETE> eliminarServicioPorId(String id) {
		RespuestaServiciosDELETE body = new RespuestaServiciosDELETE();
		body.setIdentificador(id);
		body.setEliminado(false);

		if (id.equals(null) || id == "") {
			return new ResponseEntity<RespuestaServiciosDELETE>(body,headers,HttpStatus.BAD_REQUEST);
		}
		
		long resultado =  servicioRepositorio.deleteById(id);
		
		if(resultado>0) {
			body.setEliminado(true);
			return new ResponseEntity<RespuestaServiciosDELETE>(body,headers,HttpStatus.OK);
		}else {
			return new ResponseEntity<RespuestaServiciosDELETE>(body,headers,HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public ResponseEntity<RespuestaServiciosPOST> crearServicio(Servicio servicio) {
		RespuestaServiciosPOST resp = new RespuestaServiciosPOST();
		resp.setCantidad(1);
		try {
			servicioRepositorio.insert(servicio);
			resp.getIdentificadores().add(servicio.getId());		
			resp.setCreado(true);
			return new ResponseEntity<RespuestaServiciosPOST>(resp,headers,HttpStatus.CREATED);
		}catch(Exception e) {
			resp.setCreado(false);
			return new ResponseEntity<RespuestaServiciosPOST>(resp,headers,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
