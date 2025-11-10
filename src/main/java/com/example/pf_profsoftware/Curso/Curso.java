package com.example.pf_profsoftware.Curso;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "cursos")
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Nome é obrigatório")
    @Column(nullable = false)
    private String nome;

    @Column(columnDefinition = "TEXT")
    private String descricao;

    @NotNull(message = "Nota é obrigatória")
    @Min(value = 0, message = "Nota mínima é 0")
    @Max(value = 5, message = "Nota máxima é 5")
    private Integer nota;

    @NotBlank(message = "Professor é obrigatório")
    @Column(nullable = false)
    private String nomeProfessor;

    public Curso() {}

    public Curso(String nome, String descricao, Integer nota, String nomeProfessor) {
        this.nome = nome;
        this.descricao = descricao;
        this.nota = nota;
        this.nomeProfessor = nomeProfessor;
    }

    // getters e setters
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

    @Override
    public String toString() {
        return "Curso{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", nota=" + nota +
                ", nomeProfessor='" + nomeProfessor + '\'' +
                '}';
    }
}
