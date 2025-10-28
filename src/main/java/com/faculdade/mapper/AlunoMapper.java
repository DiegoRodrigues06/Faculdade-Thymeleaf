package com.faculdade.mapper;

import com.faculdade.dto.AlunoDTO;
import com.faculdade.models.Aluno;

public class AlunoMapper {
    public static AlunoDTO toDTO(Aluno aluno) {
        AlunoDTO dto = new AlunoDTO();
        dto.setMatricula(aluno.getMatricula());
        dto.setNome(aluno.getNome());
        dto.setCursoNome(aluno.getCurso() != null ? aluno.getCurso().getNome() : null);
        dto.setCidade(aluno.getEndereco() != null ? aluno.getEndereco().getCidade() : null);
        return dto;
    }
}
