package cl.dramos.tantelise.app.clientesservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import cl.dramos.tantelise.app.clientesservice.domain.Cliente;
import cl.dramos.tantelise.app.clientesservice.domain.ClienteRepositorio;
import cl.dramos.tantelise.app.clientesservice.domain.respuestas.RespuestaClienteDELETE;
import cl.dramos.tantelise.app.clientesservice.domain.respuestas.RespuestaClienteGET;
import cl.dramos.tantelise.app.clientesservice.domain.respuestas.RespuestaClientePOST;
import cl.dramos.tantelise.app.clientesservice.domain.respuestas.RespuestaClientePUT;

@Service
public class ClienteServiceImpl implements ClienteService {
	
	@Autowired
	private ClienteRepositorio repo;
	private HttpHeaders headers;

	public  ClienteServiceImpl() {
		headers = new HttpHeaders();
		headers.add("Content-Type", "application/json; charset=UTF-8");
	}
	
	@Override
	public ResponseEntity<RespuestaClienteGET> obtenerClienteLista() {
		RespuestaClienteGET respuestaGET = new RespuestaClienteGET();
		respuestaGET.setDatos(repo.findAll());
		return new ResponseEntity<RespuestaClienteGET>(respuestaGET,headers,HttpStatus.OK);
	}

	@Override
	public ResponseEntity<RespuestaClienteGET> obtenerClientePorId(String id) {
		RespuestaClienteGET respuestaGET = new RespuestaClienteGET();
		respuestaGET.setDatos(repo.findClienteById(id));
		return new ResponseEntity<RespuestaClienteGET>(respuestaGET,headers,HttpStatus.OK);
	}

	@Override
	public ResponseEntity<RespuestaClienteGET> obtenerClientePorCorreo(String correo) {
		RespuestaClienteGET respuestaGET = new RespuestaClienteGET();
		respuestaGET.setDatos(repo.findClienteByCorreo(correo));
		return new ResponseEntity<RespuestaClienteGET>(respuestaGET,headers,HttpStatus.OK);
	}

	@Override
	public ResponseEntity<RespuestaClientePOST> crearCliente(Cliente cliente) {
		RespuestaClientePOST resp = new RespuestaClientePOST();
		resp.setCantidad(1);
		try {
			repo.insert(cliente);
			resp.getIdentificadores().add(cliente.getId());		
			resp.setCreado(true);
			return new ResponseEntity<RespuestaClientePOST>(resp,headers,HttpStatus.CREATED);
		}catch(Exception e) {
			resp.setCreado(false);
			return new ResponseEntity<RespuestaClientePOST>(resp,headers,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<RespuestaClienteDELETE> eliminarCliente(String id) {
		RespuestaClienteDELETE body = new RespuestaClienteDELETE();
		body.setIdentificador(id);
		body.setEliminado(false);

		if (id.equals(null) || id == "") {
			return new ResponseEntity<RespuestaClienteDELETE>(body,headers,HttpStatus.BAD_REQUEST);
		}
		
		long resultado =  repo.deleteClienteById(id);
		
		if(resultado>0) {
			body.setEliminado(true);
			return new ResponseEntity<RespuestaClienteDELETE>(body,headers,HttpStatus.OK);
		}else {
			return new ResponseEntity<RespuestaClienteDELETE>(body,headers,HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public ResponseEntity<RespuestaClientePUT> actualizarCliente(String id, Cliente cliente) {
		RespuestaClientePUT body = new RespuestaClientePUT();
		body.setIdentificador(cliente.getId());
		body.setActualizado(false);
		
		Cliente resultado = repo.save(cliente);
		if (resultado.equals(cliente)) {
			body.setActualizado(true);
			return new ResponseEntity<RespuestaClientePUT>(body,headers,HttpStatus.OK);
		}else if(resultado.equals(null)){
			return new ResponseEntity<RespuestaClientePUT>(body,headers,HttpStatus.INTERNAL_SERVER_ERROR);
		}else {
			return new ResponseEntity<RespuestaClientePUT>(body,headers,HttpStatus.NO_CONTENT);
		}
	}

}
