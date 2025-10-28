package com.faculdade.controller;

import com.faculdade.models.Curso;
import com.faculdade.service.CursoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/cursos")
public class CursoController {
    private final CursoService service;

    public CursoController(CursoService service) {
        this.service = service;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("cursos", service.listarTodos());
        return "cursos/lista";
    }

    @GetMapping("/novo")
    public String novoForm(Model model) {
        model.addAttribute("curso", new Curso());
        return "cursos/form";
    }

    @PostMapping
    public String salvar(@ModelAttribute Curso curso) {
        service.salvar(curso);
        return "redirect:/cursos";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable int id) {
        service.excluir(id);
        return "redirect:/cursos";
    }
}