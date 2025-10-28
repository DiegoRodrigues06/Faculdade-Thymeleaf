package com.faculdade.models;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;

    @OneToMany(mappedBy = "curso")
    private List<Aluno> alunos = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "disciplina_curso",
            joinColumns = @JoinColumn(name = "curso_id"),
            inverseJoinColumns = @JoinColumn(name = "disciplina_id")
    )
    private List<Disciplina> disciplinas = new ArrayList<>();

    // Getters e Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public List<Aluno> getAlunos() { return alunos; }
    public void setAlunos(List<Aluno> alunos) { this.alunos = alunos; }

    public List<Disciplina> getDisciplinas() { return disciplinas; }
    public void setDisciplinas(List<Disciplina> disciplinas) { this.disciplinas = disciplinas; }
}
