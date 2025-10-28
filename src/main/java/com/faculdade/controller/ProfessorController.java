package com.faculdade.controller;

import com.faculdade.models.Professor;
import com.faculdade.service.ProfessorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/professores")
public class ProfessorController {
    private final ProfessorService service;

    public ProfessorController(ProfessorService service) {
        this.service = service;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("professores", service.listarTodos());
        return "professores/lista";
    }

    @GetMapping("/novo")
    public String novoForm(Model model) {
        model.addAttribute("professor", new Professor());
        return "professores/form";
    }

    @PostMapping
    public String salvar(@ModelAttribute Professor professor) {
        service.salvar(professor);
        return "redirect:/professores";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable int id) {
        service.excluir(id);
        return "redirect:/professores";
    }
}