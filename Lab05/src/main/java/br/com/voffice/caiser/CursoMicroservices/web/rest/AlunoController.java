package br.com.voffice.caiser.CursoMicroservices.web.rest;

import br.com.voffice.caiser.CursoMicroservices.domain.Aluno;
import br.com.voffice.caiser.CursoMicroservices.repository.AlunoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

@RestController
@RequestMapping("/api")
public class AlunoController {

    private AlunoRepository alunoRepository;

    public AlunoController(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    @PostMapping("/alunos")
    public Aluno createAluno(@RequestBody Aluno aluno) {
        return this.alunoRepository.save(aluno);
    }

    @GetMapping("/alunos")
    public ResponseEntity<List<Aluno>> getAllAlunos() {

        List<Aluno> alunos = this.alunoRepository.findAll();
        return ResponseEntity.ok().body(alunos);
    }

    @PutMapping("/alunos")
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

    @GetMapping("/alunos/findByName/{nome}")
    public ResponseEntity<List<Aluno>> findByName(@PathVariable String nome) {
        List<Aluno> alunos = this.alunoRepository.findByNomeContains(nome);
        return ResponseEntity.ok().body(alunos);
    }

    @GetMapping("/alunos/findByMesAtual")
    public ResponseEntity<List<Aluno>> findAlunosByMesAniversario() {
        Integer mes = new Date().getMonth();
        List<Aluno> alunos = this.alunoRepository.findByDataNascimento(mes+1);
        return ResponseEntity.ok().body(alunos);
    }
}
