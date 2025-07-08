package com.mkelman.escola.contoller;

import java.net.URI;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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

    @GetMapping ( value = "/listaprofessor")
    public List<Professor> findAll() {
        return professorRespository.findAll();
    }

    @DeleteMapping (value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        professorRespository.deleteById(id);
        return ResponseEntity.noContent().build();
    
     }

    @PostMapping( value ="/insert") 
    public ResponseEntity<?> insert(@RequestBody ProfessorDto professorDto) {

        Professor professor = professorDto.novoProfessor();
        
        professorRespository.save(professor);
        
        System.out.println(professor.toString());

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                                             .path("id")
                                             .buildAndExpand(professor.getId())
                                             .toUri();

        return ResponseEntity.created(uri).body(professor);

    }

    
}
