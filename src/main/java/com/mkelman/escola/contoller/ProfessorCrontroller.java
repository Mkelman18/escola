package com.mkelman.escola.contoller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/professor")
public class ProfessorCrontroller {

    @GetMapping( value = "/")
    public void imprimir() {
        System.out.println("Chamou o metodo imprimir");

    }

    @GetMapping( value = "/ola")
    public String ola() {
        return"<h1>Manu<h1>";

    }
    @GetMapping (value ="/insert")
    public String insert() {
        return"<h1>tentando salvar o professor dos alunos<h2>";
    }
    
}
