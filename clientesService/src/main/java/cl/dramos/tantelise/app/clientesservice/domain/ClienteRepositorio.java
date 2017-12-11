package cl.dramos.tantelise.app.clientesservice.domain;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ClienteRepositorio extends MongoRepository<Cliente, String>{

}
