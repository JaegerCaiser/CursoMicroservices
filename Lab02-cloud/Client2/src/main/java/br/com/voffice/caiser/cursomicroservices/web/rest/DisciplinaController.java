package br.com.voffice.caiser.cursomicroservices.web.rest;

import br.com.voffice.caiser.cursomicroservices.domain.DisciplinaDTO;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.List;

@RestController
public class DisciplinaController {

    @Autowired
    private DiscoveryClient discoveryClient;

    private RestTemplate restTemplate;

    @GetMapping
    public ResponseEntity<DisciplinaDTO> getDisciplina() {
        DisciplinaDTO disciplinaDTO = new DisciplinaDTO();
        disciplinaDTO.setNome("Workshop Microservices");
        disciplinaDTO.setCargaHoraria(40);
        disciplinaDTO.setDataInicio(new Date(2018-1900, 06, 05));

        disciplinaDTO.getAlunosMatriculados().addAll(getAlunos());

        return ResponseEntity.ok(disciplinaDTO);
    }

    private List<String> getAlunos() {
        List<ServiceInstance> instances = this.discoveryClient.getInstances("aluno-service");
        ServiceInstance fisrtOne = instances.get(0);

        restTemplate = new RestTemplate();
        ResponseEntity<JsonNode> alunos = restTemplate.getForEntity("http://" + fisrtOne.getHost() + ":" +
        fisrtOne.getPort() + "/alunos", JsonNode.class);

        return alunos.getBody().findValuesAsText("nome");
    }
}
