package cl.tantelise.productosservice.categorias;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface CategoriaRepositorio extends MongoRepository<Categoria, String> {

}
