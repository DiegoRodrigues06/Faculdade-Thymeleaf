package com.faculdade.models;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Disciplina {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nome;

    @ManyToMany(mappedBy = "disciplinas")
    private List<Curso> cursos = new ArrayList<>();

    // Getters e Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public List<Curso> getCursos() { return cursos; }
    public void setCursos(List<Curso> cursos) { this.cursos = cursos; }
}
