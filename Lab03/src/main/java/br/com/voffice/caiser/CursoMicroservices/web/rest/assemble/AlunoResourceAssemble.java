package br.com.voffice.caiser.CursoMicroservices.web.rest.assemble;

import br.com.voffice.caiser.CursoMicroservices.domain.Aluno;
import br.com.voffice.caiser.CursoMicroservices.web.rest.AlunoController;
import br.com.voffice.caiser.CursoMicroservices.web.rest.resource.AlunoResource;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@Component
public class AlunoResourceAssemble extends ResourceAssemblerSupport<Aluno, AlunoResource> {
    public AlunoResourceAssemble() {
        super(AlunoController.class, AlunoResource.class);
    }

    @Override
    public AlunoResource toResource(Aluno aluno) {
        return createResource(aluno);
    }

    public AlunoResource createResource(Aluno aluno) {
        AlunoResource alunoResource = new AlunoResource(aluno, linkTo(methodOn(AlunoController.class).getAllAlunos()).slash(aluno).withSelfRel());
        return alunoResource;
    }
}
