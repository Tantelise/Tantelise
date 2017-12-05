package cl.dramos.tantelise.app.productosservice.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

@Configuration
public class Oauth2Config extends ResourceServerConfigurerAdapter {
	
	private static final String[] PUBLIC_MATCHS = {"/swagger-ui.html", "/swagger-resources/**", "/v2/**", "/productos**","/adicionales**"};
	
	private static final String[] USER_MATCHS = { "/productos/**","/adicionales/**"};

	
	private static final String USUARIO_ROL = "USUARIO";

	@Override
	public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
		resources.resourceId("productosService");
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
            .antMatchers(HttpMethod.GET, PUBLIC_MATCHS).permitAll()        
            .antMatchers(HttpMethod.DELETE, USER_MATCHS).hasRole(USUARIO_ROL)
            .antMatchers(HttpMethod.GET, USER_MATCHS).hasRole(USUARIO_ROL)
            .antMatchers(HttpMethod.POST, USER_MATCHS).hasRole(USUARIO_ROL)
            .antMatchers(HttpMethod.PUT, USER_MATCHS).hasRole(USUARIO_ROL)          
        	.anyRequest().authenticated();
	}
}
