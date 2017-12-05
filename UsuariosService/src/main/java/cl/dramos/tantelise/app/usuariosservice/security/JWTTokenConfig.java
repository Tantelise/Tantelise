package cl.dramos.tantelise.app.usuariosservice.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JWTTokenConfig {
	
	@Value("${signing.key}")
	private String jwtSigningKey = "";
	
	
	public String getJwtSigningKey() {
		return jwtSigningKey;
	}

}
