package cl.dramos.tantelise.app.usuariosservice.domain;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface UsuarioRepositorio extends MongoRepository<Usuario, String> {
	
	public Usuario findUsuarioByUsuario(String username);

}
