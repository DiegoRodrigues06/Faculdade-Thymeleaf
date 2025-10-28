package com.faculdade.models;

import jakarta.persistence.*;

@Entity
public class Aluno {
    @Id
    private int matricula;
    private String nome;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="endereco_id")
    private Endereco endereco;

    @ManyToOne
    @JoinColumn(name="curso_id")
    private Curso curso;

    // Getters e Setters
    public int getMatricula() { return matricula; }
    public void setMatricula(int matricula) { this.matricula = matricula; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public Endereco getEndereco() { return endereco; }
    public void setEndereco(Endereco endereco) { this.endereco = endereco; }

    public Curso getCurso() { return curso; }
    public void setCurso(Curso curso) { this.curso = curso; }
}