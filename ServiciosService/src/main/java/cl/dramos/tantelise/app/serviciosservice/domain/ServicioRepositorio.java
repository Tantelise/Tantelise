package cl.dramos.tantelise.app.serviciosservice.domain;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ServicioRepositorio extends MongoRepository<Servicio, String>{
	
	public List<Servicio> findById(String id);

	public long deleteById(String id);

}
