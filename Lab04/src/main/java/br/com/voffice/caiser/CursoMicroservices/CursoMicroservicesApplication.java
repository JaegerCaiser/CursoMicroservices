package br.com.voffice.caiser.CursoMicroservices;

import br.com.voffice.caiser.CursoMicroservices.config.ApplicationProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CursoMicroservicesApplication implements CommandLineRunner {
	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	ApplicationProperties applicationProperties;

	public static void main(String[] args) {
		SpringApplication.run(CursoMicroservicesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info(applicationProperties.getFrase());
	}
}
