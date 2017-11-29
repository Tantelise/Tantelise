package cl.dramos.tantelise.app.productosservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class ProductosServiceMain {

	public static void main(String[] args) {
		SpringApplication.run(ProductosServiceMain.class, args);
	}

}
