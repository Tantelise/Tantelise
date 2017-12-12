package cl.dramos.tantelise.app.clientesservice.domain;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ClienteRepositorio extends MongoRepository<Cliente, String>{
	
	public Cliente findClienteById(String id);
	public Cliente findClienteByCorreo(String correo);
	public int deleteClienteById(String id);

}
