package com.faculdade.controller;

import com.faculdade.models.Aluno;
import com.faculdade.service.AlunoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/alunos")
public class AlunoController {
    private final AlunoService service;

    public AlunoController(AlunoService service) {
        this.service = service;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("alunos", service.listarTodos());
        return "alunos/lista"; // (HTML)
    }

    @GetMapping("/novo")
    public String novoForm(Model model) {
        model.addAttribute("aluno", new Aluno());
        return "alunos/form"; // (HTML)
    }

    @PostMapping
    public String salvar(@ModelAttribute Aluno aluno) {
        service.salvar(aluno);
        return "redirect:/alunos";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable int id) {
        service.excluir(id);
        return "redirect:/alunos";
    }
}