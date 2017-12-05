package cl.dramos.tantelise.app.usuariosservice.security;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

import cl.dramos.tantelise.app.usuariosservice.service.UsuariosService;

@Configuration
public class Oauth2Config extends AuthorizationServerConfigurerAdapter{

	
	@Autowired
	private AuthenticationManager autenticationManager;
	
	@Autowired
	private UsuariosService usuarioService;
	
	@Autowired
	private TokenStore tokenStore;

	@Autowired
	private JwtAccessTokenConverter jwtAccessTokenConverter;
	
	@Autowired
	private TokenEnhancer jwtTokenEnhancer;

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
		TokenEnhancerChain tokenEnhancerChain = new TokenEnhancerChain();
		tokenEnhancerChain.setTokenEnhancers(Arrays.asList(jwtTokenEnhancer, jwtAccessTokenConverter));
		
		endpoints.tokenStore(tokenStore);
		endpoints.accessTokenConverter(jwtAccessTokenConverter);
		endpoints.authenticationManager(autenticationManager);
		endpoints.userDetailsService(usuarioService);
	
	}
	
	
	

}
