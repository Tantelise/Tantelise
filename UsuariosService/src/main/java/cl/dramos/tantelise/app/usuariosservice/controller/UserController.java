package cl.dramos.tantelise.app.usuariosservice.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.dramos.tantelise.app.usuariosservice.domain.Usuario;
import cl.dramos.tantelise.app.usuariosservice.service.UsuariosService;

@RestController
@RequestMapping("usuarios")
public class UserController {
	
	@Autowired
	private UsuariosService usuarioService;
	
	@GetMapping(path="/{usuario}")
	public Usuario encontrarUsuario(@PathVariable String usuario) {
		return usuarioService.buscarUsuario(usuario);
	}
	
	@GetMapping(path="/info")
	public Map<String,Object> obtenerInformacionUsuario(OAuth2Authentication usuario){
		Map<String,Object> userInfo = new HashMap<>();
		userInfo.put("usuario", usuario.getUserAuthentication().getPrincipal());
		return userInfo;
	}

}
