package com.faculdade.service;

import com.faculdade.models.Curso;
import com.faculdade.repository.CursoRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CursoService {
    private final CursoRepository repo;

    public CursoService(CursoRepository repo) {
        this.repo = repo;
    }

    public List<Curso> listarTodos() {
        return repo.findAll();
    }

    public void salvar(Curso curso) {
        repo.save(curso);
    }

    public void excluir(int id) {
        repo.deleteById(id);
    }

    public Curso buscarPorId(int id) {
        return repo.findById(id).orElse(null);
    }
}