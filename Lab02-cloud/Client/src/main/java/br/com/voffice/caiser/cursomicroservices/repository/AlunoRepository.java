package br.com.voffice.caiser.cursomicroservices.repository;

import br.com.voffice.caiser.cursomicroservices.domain.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "/alunos")
public interface AlunoRepository extends JpaRepository<Aluno, Long> {
}
