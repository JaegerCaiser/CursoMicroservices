package br.com.voffice.caiser.cursomicroservices.domain;

import java.util.Date;
import java.util.List;

public class DisciplinaDTO {
    private String nome;
    private Integer cargaHoraria;
    private Date dataInicio;
    private List<String> alunosMatriculados;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(Integer cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public List<String> getAlunosMatriculados() {
        return alunosMatriculados;
    }

    public void setAlunosMatriculados(List<String> alunosMatriculados) {
        this.alunosMatriculados = alunosMatriculados;
    }
}
