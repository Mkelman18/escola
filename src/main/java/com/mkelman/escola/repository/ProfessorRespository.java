package com.mkelman.escola.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mkelman.escola.modelo.Professor;

public interface ProfessorRespository extends JpaRepository<Professor, Long> {
    
}
