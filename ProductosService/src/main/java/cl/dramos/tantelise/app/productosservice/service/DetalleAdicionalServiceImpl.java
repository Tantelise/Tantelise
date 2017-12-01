package cl.dramos.tantelise.app.productosservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import cl.dramos.tantelise.app.productosservice.domain.DetalleAdicional;
import cl.dramos.tantelise.app.productosservice.domain.DetalleAdicionalRepository;
import cl.dramos.tantelise.app.productosservice.domain.respuestas.RespuestaDetalleAdicionalServiceDELETE;
import cl.dramos.tantelise.app.productosservice.domain.respuestas.RespuestaDetalleAdicionalServiceGET;
import cl.dramos.tantelise.app.productosservice.domain.respuestas.RespuestaDetalleAdicionalServicePOST;
import cl.dramos.tantelise.app.productosservice.domain.respuestas.RespuestaDetalleAdicionalServicePUT;


@Service
public class DetalleAdicionalServiceImpl implements DetalleAdicionalService{
	
	@Autowired 
	private DetalleAdicionalRepository detalleAdicionalRepo;
	private HttpHeaders headers;

	public DetalleAdicionalServiceImpl() {
		headers = new HttpHeaders();
		headers.add("Content-Type", "application/json; charset=UTF-8");
	}

	@Override
	public ResponseEntity<RespuestaDetalleAdicionalServiceGET> obtenerDetalleAdicionalLista() {
		RespuestaDetalleAdicionalServiceGET respuestaGET = new RespuestaDetalleAdicionalServiceGET();
		respuestaGET.setDatos(detalleAdicionalRepo.findAll());
		return new ResponseEntity<RespuestaDetalleAdicionalServiceGET>(respuestaGET,headers,HttpStatus.OK);
	}

	@Override
	public ResponseEntity<RespuestaDetalleAdicionalServiceGET> obtenerDetalleAdicionalPorID(String id) {
		return null;
	}

	@Override
	public ResponseEntity<RespuestaDetalleAdicionalServiceDELETE> eliminarDetalleAdicional(String id) {
		RespuestaDetalleAdicionalServiceDELETE body = new RespuestaDetalleAdicionalServiceDELETE();
		body.setIdentificador(id);
		body.setEliminado(false);

		if (id.equals(null) || id == "") {
			return new ResponseEntity<RespuestaDetalleAdicionalServiceDELETE>(body,headers,HttpStatus.BAD_REQUEST);
		}
		
		long resultado =  detalleAdicionalRepo.deleteById(id);
		
		if(resultado>0) {
			body.setEliminado(true);
			return new ResponseEntity<RespuestaDetalleAdicionalServiceDELETE>(body,headers,HttpStatus.OK);
		}else {
			return new ResponseEntity<RespuestaDetalleAdicionalServiceDELETE>(body,headers,HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public ResponseEntity<RespuestaDetalleAdicionalServicePUT> actualizarDetalleAdicional(
			DetalleAdicional detalleAdicional) {
		RespuestaDetalleAdicionalServicePUT body = new RespuestaDetalleAdicionalServicePUT();
		body.setIdentificador(detalleAdicional.getId());
		body.setActualizado(false);
		
		DetalleAdicional resultado = detalleAdicionalRepo.save(detalleAdicional);
		if (resultado.equals(detalleAdicional)) {
			body.setActualizado(true);
			return new ResponseEntity<RespuestaDetalleAdicionalServicePUT>(body,headers,HttpStatus.OK);
		}else if(resultado.equals(null)){
			return new ResponseEntity<RespuestaDetalleAdicionalServicePUT>(body,headers,HttpStatus.INTERNAL_SERVER_ERROR);
		}else {
			return new ResponseEntity<RespuestaDetalleAdicionalServicePUT>(body,headers,HttpStatus.NO_CONTENT);
		}
	}

	@Override
	public ResponseEntity<RespuestaDetalleAdicionalServicePOST> crearDetalleAdicional(
			DetalleAdicional detalleAdicional) {
		RespuestaDetalleAdicionalServicePOST resp = new RespuestaDetalleAdicionalServicePOST();
		resp.setCantidad(1);
		try {
			detalleAdicionalRepo.insert(detalleAdicional);
			resp.getIdentificadores().add(detalleAdicional.getId());		
			resp.setCreado(true);
			return new ResponseEntity<RespuestaDetalleAdicionalServicePOST>(resp,headers,HttpStatus.CREATED);
		}catch(Exception e) {
			resp.setCreado(false);
			return new ResponseEntity<RespuestaDetalleAdicionalServicePOST>(resp,headers,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
