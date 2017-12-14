package cl.dramos.tantelise.app.productosservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@EnableEurekaClient
@SpringBootApplication
@EnableResourceServer
public class ProductosServiceMain {
	
	private final static Logger log = LoggerFactory.getLogger(ProductosServiceMain.class);

	public static void main(String[] args) {
		SpringApplication.run(ProductosServiceMain.class, args);
		log.trace("Iniciando aplicación");

	}
}
