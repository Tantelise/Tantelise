package cl.tantelise.productosservice.productos;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductosRepositorio extends MongoRepository<Producto, String>{


}
