package com.mkelman.escola.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mkelman.escola.modelo.Professor;

public interface ProfessorRespository extends JpaRepository<Professor, Long> {
    
@Query (value = "select * from professor where nome like ?", nativeQuery = true )
    public Professor findByIdNome(String nome);
}
