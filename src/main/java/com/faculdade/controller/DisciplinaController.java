package com.faculdade.controller;

import com.faculdade.models.Disciplina;
import com.faculdade.service.DisciplinaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/disciplinas")
public class DisciplinaController {
    private final DisciplinaService service;

    public DisciplinaController(DisciplinaService service) {
        this.service = service;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("disciplinas", service.listarTodos());
        return "disciplina/lista";
    }

    @GetMapping("/novo")
    public String novoForm(Model model) {
        model.addAttribute("disciplina", new Disciplina());
        return "disciplina/form";
    }

    @PostMapping
    public String salvar(@ModelAttribute Disciplina disciplina) {
        service.salvar(disciplina);
        return "redirect:/disciplinas";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable int id) {
        service.excluir(id);
        return "redirect:/disciplinas";
    }
}