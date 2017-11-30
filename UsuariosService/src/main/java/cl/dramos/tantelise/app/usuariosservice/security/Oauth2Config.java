package cl.dramos.tantelise.app.usuariosservice.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;

import cl.dramos.tantelise.app.usuariosservice.service.UsuariosService;

@Configuration
public class Oauth2Config extends AuthorizationServerConfigurerAdapter{

	
	@Autowired
	private AuthenticationManager autenticationManager;
	
	@Autowired
	private UsuariosService usuarioService;

	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		clients.inMemory()
			.withClient("cliente")
			.secret("secreto")
			.authorizedGrantTypes("refresh_token","password","client_credentials")
			.scopes("web");
	}

	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		endpoints.authenticationManager(autenticationManager);
		endpoints.userDetailsService(usuarioService);
	
	}
	
	
	

}
