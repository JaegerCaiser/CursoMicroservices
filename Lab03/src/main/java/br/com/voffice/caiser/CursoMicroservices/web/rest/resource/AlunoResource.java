package br.com.voffice.caiser.CursoMicroservices.web.rest.resource;

import br.com.voffice.caiser.CursoMicroservices.domain.Aluno;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;

public class AlunoResource extends Resource<Aluno> {
    public AlunoResource(Aluno content, Link... links) {
        super(content, links);
    }

    public AlunoResource(Aluno content, Iterable<Link> links) {
        super(content, links);
    }
}
