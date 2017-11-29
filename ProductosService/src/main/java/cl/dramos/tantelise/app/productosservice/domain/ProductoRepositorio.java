package cl.dramos.tantelise.app.productosservice.domain;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductoRepositorio extends MongoRepository<Producto,String> {
	
	public long deleteById(String id);

}
