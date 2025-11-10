package com.example.pf_profsoftware.Curso;

public class CursoResponse {
    private Long id;
    private String nome;
    private String descricao;
    private Integer nota;
    private String nomeProfessor;

    public CursoResponse() {}

    public CursoResponse(Long id, String nome, String descricao, Integer nota, String nomeProfessor) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.nota = nota;
        this.nomeProfessor = nomeProfessor;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    public Integer getNota() { return nota; }
    public void setNota(Integer nota) { this.nota = nota; }
    public String getNomeProfessor() { return nomeProfessor; }
    public void setNomeProfessor(String nomeProfessor) { this.nomeProfessor = nomeProfessor; }
}
