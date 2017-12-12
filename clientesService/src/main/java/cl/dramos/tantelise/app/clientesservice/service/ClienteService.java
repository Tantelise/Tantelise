package cl.dramos.tantelise.app.clientesservice.service;

import org.springframework.http.ResponseEntity;

import cl.dramos.tantelise.app.clientesservice.domain.Cliente;
import cl.dramos.tantelise.app.clientesservice.domain.respuestas.RespuestaClienteDELETE;
import cl.dramos.tantelise.app.clientesservice.domain.respuestas.RespuestaClienteGET;
import cl.dramos.tantelise.app.clientesservice.domain.respuestas.RespuestaClientePOST;
import cl.dramos.tantelise.app.clientesservice.domain.respuestas.RespuestaClientePUT;

public interface ClienteService {
	
	public ResponseEntity<RespuestaClienteGET> obtenerClienteLista();
	public ResponseEntity<RespuestaClienteGET> obtenerClientePorId(String id);
	public ResponseEntity<RespuestaClienteGET> obtenerClientePorCorreo(String correo);
	public ResponseEntity<RespuestaClientePOST> crearCliente(Cliente cliente);
	public ResponseEntity<RespuestaClienteDELETE> eliminarCliente(String id);
	public ResponseEntity<RespuestaClientePUT> actualizarCliente(String id, Cliente cliente);



}
