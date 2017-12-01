package cl.dramos.tantelise.app.serviciosservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ServiciosServiceApp {
	
	public static void main(String ... args) {
		SpringApplication.run(ServiciosServiceApp.class, args);
	}

}
