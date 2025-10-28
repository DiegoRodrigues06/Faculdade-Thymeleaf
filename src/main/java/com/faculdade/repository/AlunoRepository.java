package com.faculdade.repository;

import com.faculdade.models.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Integer> {}