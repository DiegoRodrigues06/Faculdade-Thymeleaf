package com.faculdade.controller;

import com.faculdade.models.Aluno;
import com.faculdade.service.AlunoService;
import com.faculdade.service.CursoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/alunos")
public class AlunoController {

    private final AlunoService alunoService;
    private final CursoService cursoService;

    public AlunoController(AlunoService alunoService, CursoService cursoService) {
        this.alunoService = alunoService;
        this.cursoService = cursoService;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("alunos", alunoService.listarTodos());
        return "alunos/lista"; // Retorna/renderiza a pagina html em (path)
    }

    @GetMapping("/novo")
    public String novoForm(Model model) {
        model.addAttribute("aluno", new Aluno());
        model.addAttribute("cursos", cursoService.listarTodos()); // Busca todos os cursos e manda pro template
        return "alunos/form";
    }

    @PostMapping
    public String salvar(@ModelAttribute("aluno") Aluno aluno) {
        alunoService.salvar(aluno);
        return "redirect:/alunos";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable int id, Model model) {
        model.addAttribute("aluno", alunoService.buscarPorId(id));
        model.addAttribute("cursos", cursoService.listarTodos());
        // função descartada, foi só pra completar o CRUD mas nem vale a pena implementar no front
        return "alunos/form";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable int id) {
        alunoService.excluir(id);
        return "redirect:/alunos";
    }
}
