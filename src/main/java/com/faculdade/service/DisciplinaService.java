package com.faculdade.service;

import com.faculdade.models.Disciplina;
import com.faculdade.repository.DisciplinaRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DisciplinaService {

    private final DisciplinaRepository repo;

    public DisciplinaService(DisciplinaRepository repo) {
        this.repo = repo;
    }

    public List<Disciplina> listarTodos() {
        return repo.findAll();
    }

    public Disciplina buscarPorId(int id) {
        return repo.findById(id).orElse(null);
    }

    public void salvar(Disciplina disciplina) {
        repo.save(disciplina);
    }

    public void excluir(int id) {
        repo.deleteById(id);
    }
}
