package cl.dramos.tantelise.app.usuariosservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class UsuariosServiceMain {

	public static void main(String[] args) {
		SpringApplication.run(UsuariosServiceMain.class, args);
	}

}
