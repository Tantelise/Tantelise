package cl.dramos.tantelise.app.usuariosservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication
@EnableEurekaClient
@EnableAuthorizationServer
@EnableResourceServer
public class UsuariosServiceMain {

	public static void main(String[] args) {
		SpringApplication.run(UsuariosServiceMain.class, args);
	}

}


