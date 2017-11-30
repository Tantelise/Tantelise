package cl.dramos.tantelise.app.usuariosservice.domain;

import org.springframework.security.core.GrantedAuthority;

public class Rol implements GrantedAuthority{
	
	private static final long serialVersionUID = 1L;
	private String rolNombre;
	

	public Rol(String rolNombre) {
		this.rolNombre = rolNombre;
	}

	@Override
	public String getAuthority() {
		return rolNombre;
	}
}
