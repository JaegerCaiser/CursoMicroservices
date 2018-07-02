package br.com.voffice.caiser.cursomicroservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class CursomicroservicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(CursomicroservicesApplication.class, args);
	}
}
