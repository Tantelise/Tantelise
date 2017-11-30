package cl.dramos.tantelise.app.usuariosservice.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import cl.dramos.tantelise.app.usuariosservice.domain.Usuario;

public interface UsuariosService extends UserDetailsService{

	Usuario buscarUsuario(String usuario);

}
