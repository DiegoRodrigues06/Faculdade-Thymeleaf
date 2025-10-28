package com.faculdade.service;

import com.faculdade.models.Aluno;
import com.faculdade.repository.AlunoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Aluno buscarPorId(int id) {
        Optional<Aluno> aluno = repo.findById(id);
        return aluno.orElse(null); // retorna o aluno ou null se não existir
    }
}
