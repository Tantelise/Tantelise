package cl.dramos.tantelise.app.productosservice.domain;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface DetalleAdicionalRepository extends MongoRepository<DetalleAdicional, String> {

	public long deleteById(String id);

}
