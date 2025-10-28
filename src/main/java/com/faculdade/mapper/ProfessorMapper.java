package com.faculdade.mapper;

import com.faculdade.dto.ProfessorDTO;
import com.faculdade.models.Professor;

public class ProfessorMapper {
    public static ProfessorDTO toDTO(Professor professor) {
        ProfessorDTO dto = new ProfessorDTO();
        dto.setId(professor.getMatricula());
        dto.setNome(professor.getNome());
        dto.setDepartamento(professor.getDepartamento());
        return dto;
    }

    public static Professor toEntity(ProfessorDTO dto) {
        Professor professor = new Professor();
        professor.setMatricula(dto.getId());
        professor.setNome(dto.getNome());
        professor.setDepartamento(dto.getDepartamento());
        return professor;
    }
}