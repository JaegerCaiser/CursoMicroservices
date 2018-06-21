package br.com.voffice.caiser.CursoMicroservices.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class ApplicationProperties {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Value("${teste.hello-world}")
    private String frase;

    @Autowired
    Environment env;

    public String getFrase() {
        return frase;
    }

    @Bean
    public String beanTeste() {
        logger.info(env.getProperty("teste.bean.chama"));
        return "Funcionou!!!!";
    }
}
