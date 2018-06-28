package br.com.voffice.caiser.cursomicroservices.web.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class PropertiesResources {

    @Value("${app}")
    private String appProperty;

    @GetMapping("/properties")
    public String getPropertyApp() {
        return this.appProperty;
    }
}
