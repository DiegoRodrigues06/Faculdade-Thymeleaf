package com.faculdade.dto;

public class AlunoDTO {
    private int matricula;
    private String nome;
    private String cursoNome;
    private String cidade;

    // Getters e Setters
    public int getMatricula() { return matricula; }
    public void setMatricula(int matricula) { this.matricula = matricula; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getCursoNome() { return cursoNome; }
    public void setCursoNome(String cursoNome) { this.cursoNome = cursoNome; }

    public String getCidade() { return cidade; }
    public void setCidade(String cidade) { this.cidade = cidade; }
}