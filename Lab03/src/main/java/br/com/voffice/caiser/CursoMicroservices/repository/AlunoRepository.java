package br.com.voffice.caiser.CursoMicroservices.repository;

import br.com.voffice.caiser.CursoMicroservices.domain.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {

}
