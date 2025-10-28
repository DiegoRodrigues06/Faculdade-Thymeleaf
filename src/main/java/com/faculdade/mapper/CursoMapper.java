package com.faculdade.mapper;

import com.faculdade.dto.CursoDTO;
import com.faculdade.models.Curso;

public class CursoMapper {
    public static CursoDTO toDTO(Curso curso) {
        CursoDTO dto = new CursoDTO();
        dto.setId(curso.getId());
        dto.setNome(curso.getNome());
        return dto;
    }

    public static Curso toEntity(CursoDTO dto) {
        Curso curso = new Curso();
        curso.setId(dto.getId());
        curso.setNome(dto.getNome());
        return curso;
    }
}
