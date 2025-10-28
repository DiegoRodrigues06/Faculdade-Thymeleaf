package com.faculdade.service;

import com.faculdade.models.Aluno;
import com.faculdade.repository.AlunoRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AlunoService {
    private final AlunoRepository repo;

    public AlunoService(AlunoRepository repo) {
        this.repo = repo;
    }

    public List<Aluno> listarTodos() {
        return repo.findAll();
    }

    public void salvar(Aluno aluno) {
        repo.save(aluno);
    }

    public void excluir(int matricula) {
        repo.deleteById(matricula);
    }
}