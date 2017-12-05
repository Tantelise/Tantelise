package cl.dramos.tantelise.app.productosservice.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TokenConfig {

	@Value("${signing.key}")
	private String jwtSigningKey = "";
	
	public String getJwtSignignKey() {
		return this.jwtSigningKey;
	}
}
