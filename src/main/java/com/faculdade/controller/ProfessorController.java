package com.faculdade.controller;

import com.faculdade.models.Professor;
import com.faculdade.models.Disciplina;
import com.faculdade.service.ProfessorService;
import com.faculdade.service.DisciplinaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/professores")
public class ProfessorController {
    private final ProfessorService professorService;
    private final DisciplinaService disciplinaService;

    public ProfessorController(ProfessorService professorService, DisciplinaService disciplinaService) {
        this.professorService = professorService;
        this.disciplinaService = disciplinaService;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("professores", professorService.listarTodos());
        return "professores/lista";
    }

    @GetMapping("/novo")
    public String novoForm(Model model) {
        model.addAttribute("professor", new Professor());
        model.addAttribute("disciplinas", disciplinaService.listarTodos());
        return "professores/form";
    }

    @PostMapping
    public String salvar(@ModelAttribute Professor professor) {
        List<Disciplina> disciplinasSelecionadas = new ArrayList<>();

        if (professor.getDisciplinas() != null) {
            for (Disciplina d : professor.getDisciplinas()) {
                Disciplina real = disciplinaService.buscarPorId(d.getId());
                if (real != null) disciplinasSelecionadas.add(real);
            }
        }

        professor.setDisciplinas(disciplinasSelecionadas);
        professorService.salvar(professor);
        return "redirect:/professores";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable int id) {
        professorService.excluir(id);
        return "redirect:/professores";
    }
}
