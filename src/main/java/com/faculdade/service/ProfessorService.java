package com.faculdade.service;

import com.faculdade.models.Professor;
import com.faculdade.repository.ProfessorRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProfessorService {
    private final ProfessorRepository repo;

    public ProfessorService(ProfessorRepository repo) {
        this.repo = repo;
    }

    public List<Professor> listarTodos() {
        return repo.findAll();
    }

    public void salvar(Professor professor) {
        repo.save(professor);
    }

    public void excluir(int id) {
        repo.deleteById(id);
    }

    public Professor buscarPorId(int id) {
        return repo.findById(id).orElse(null);
    }
}