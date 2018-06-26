package br.com.voffice.caiser.CursoMicroservices.repository;

import br.com.voffice.caiser.CursoMicroservices.domain.Disciplina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource(path = "/disciplinas")
public interface DisciplinaRepository extends JpaRepository<Disciplina, Long> {
    @RestResource(path = "next", rel = "next")
    @Query("FROM Disciplina d WHERE d.dataInicio > CURRENT_DATE")
    List<Disciplina> findDisciplinasByDataInicioAfter();
}
