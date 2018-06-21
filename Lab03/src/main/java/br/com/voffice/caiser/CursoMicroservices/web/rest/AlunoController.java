package br.com.voffice.caiser.CursoMicroservices.web.rest;

import br.com.voffice.caiser.CursoMicroservices.domain.Aluno;
import br.com.voffice.caiser.CursoMicroservices.repository.AlunoRepository;
import br.com.voffice.caiser.CursoMicroservices.web.rest.assemble.AlunoResourceAssemble;
import br.com.voffice.caiser.CursoMicroservices.web.rest.resource.AlunoResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class AlunoController {

    private AlunoRepository alunoRepository;

    private AlunoResourceAssemble assembler;

    public AlunoController(AlunoRepository alunoRepository, AlunoResourceAssemble assembler) {
        this.alunoRepository = alunoRepository;
        this.assembler = assembler;
    }

    @PostMapping("/alunos")
    public Aluno createAluno(Aluno aluno) {
        return this.alunoRepository.save(aluno);
    }

    @GetMapping(value = "/alunos", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<List<AlunoResource>> getAllAlunos() {
        List<Aluno> alunos = this.alunoRepository.findAll();
        List<AlunoResource> alunoResources = assembler.toResources(alunos);
        return ResponseEntity.ok().body(alunoResources);
    }

    @PutMapping(value = "/alunos")
    public Aluno updateAluno(@RequestBody Aluno aluno) {
        return this.alunoRepository.save(aluno);
    }

    @DeleteMapping("/alunos/{id}")
    public ResponseEntity deleteAluno(@PathVariable Long id) {
        try {
            this.alunoRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/alunos/{id}")
    public ResponseEntity<AlunoResource> findById(@PathVariable Long id) {
        Optional<Aluno> aluno = this.alunoRepository.findById(id);
        if(aluno.isPresent()) {
            AlunoResource alunoResource = assembler.toResource(aluno.get());
            return ResponseEntity.ok().body(alunoResource);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }
}
