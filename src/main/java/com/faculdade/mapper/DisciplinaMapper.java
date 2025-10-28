package com.faculdade.mapper;

import com.faculdade.dto.DisciplinaDTO;
import com.faculdade.models.Disciplina;

public class DisciplinaMapper {
    public static DisciplinaDTO toDTO(Disciplina disciplina) {
        DisciplinaDTO dto = new DisciplinaDTO();
        dto.setId(disciplina.getId());
        dto.setNome(disciplina.getNome());
        return dto;
    }

    public static Disciplina toEntity(DisciplinaDTO dto) {
        Disciplina disciplina = new Disciplina();
        disciplina.setId(dto.getId());
        disciplina.setNome(dto.getNome());
        return disciplina;
    }
}