package cl.dramos.tantelise.app.clientesservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ClientesServiceMain {

	public static void main(String ...strings ) {
		SpringApplication.run(ClientesServiceMain.class, strings);
	}
}
