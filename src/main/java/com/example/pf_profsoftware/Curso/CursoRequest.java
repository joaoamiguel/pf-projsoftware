package com.example.pf_profsoftware.Curso;

import jakarta.validation.constraints.*;

public class CursoRequest {
    @NotBlank(message = "Nome é obrigatório")
    private String nome;

    private String descricao;

    @NotNull(message = "Nota é obrigatória")
    @Min(value = 0, message = "Nota mínima é 0")
    @Max(value = 5, message = "Nota máxima é 5")
    private Integer nota;

    @NotBlank(message = "Professor é obrigatório")
    private String nomeProfessor;

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public Integer getNota() { return nota; }
    public void setNota(Integer nota) { this.nota = nota; }

    public String getNomeProfessor() { return nomeProfessor; }
    public void setNomeProfessor(String nomeProfessor) { this.nomeProfessor = nomeProfessor; }
}
