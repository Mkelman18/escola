package com.mkelman.escola.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mkelman.escola.dto.ProfessorDto;
import com.mkelman.escola.modelo.Professor;
import com.mkelman.escola.repository.ProfessorRespository;

@RestController //transforma nossa classe em um controller
@RequestMapping(value = "/professor") //mapeando a url, navegador chama pelo bean
public class ProfessorCrontroller { 
    
    @Autowired
    private ProfessorRespository professorRespository;

    @GetMapping( value = "/imprimir") //mapeando o metodo imprimir, usando o verbo get -> pegar ou buscar
    public void imprimir() { //void -> nao retorna nada 
        System.out.println("Chamou o metodo imprimir");

    }

    @GetMapping( value = "/ola")
    public String ola() { //adicionado retorno como string -> tipo texto
        return"<h1>Manu <3 </h1>"; //return -> devolve o retorno para quem chamou 

    }
    @GetMapping( value ="/insert") 
    public String insert(@RequestBody ProfessorDto professorDto) {

        Professor professor = professorDto.novoProfessor();
        
        professorRespository.save(professor);
        
        System.out.println(professor.toString());
        
        return"<h1>tentando salvar o professor dos alunos</h1>";

    }
    
}
