package br.com.voffice.caiser.CursoMicroservices.repository;

import br.com.voffice.caiser.CursoMicroservices.domain.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {

    List<Aluno> findByNomeContains(String nome);

    @Query(value = "SELECT a FROM Aluno a WHERE MONTH(a.dataNascimento) = :mes")
    List<Aluno> findByDataNascimento(@Param("mes") Integer mes);

}
