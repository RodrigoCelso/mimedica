package com.ufmt.mimedica.especialidadeMedico;

import java.util.List;
import java.util.Optional;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path="/especialidade-medico")
@RequiredArgsConstructor
public class EspecialidadeMedicoController {

    private final EspecialidadeMedicoRepository repository;

    @GetMapping(path="/")
    public List<EspecialidadeMedico> index(){
        return repository.findAll();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<EspecialidadeMedico> getById(@PathVariable int id){
        Optional<EspecialidadeMedico> found = repository.findById(id);

        if(found.isPresent()){
            EspecialidadeMedico especialidadeMedico = found.get();
            return ResponseEntity.ok().body(especialidadeMedico);
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping(path = "/{pk}")
    public ResponseEntity<Void> deleteById(@PathVariable(name = "pk") int id){
        try{
            repository.deleteById(id);
            return ResponseEntity.ok().build();
        }catch(EmptyResultDataAccessException erro){
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<String> cadastrar(@RequestBody EspecialidadeMedico especialidadeMedico){        
        try {
            repository.save(especialidadeMedico);
        } catch(IllegalArgumentException e){
            e.printStackTrace();
            return ResponseEntity.badRequest().body("Dados Inválidos!");
        }

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PatchMapping(path = "/{id}")
    public ResponseEntity<String> atualizar(@PathVariable int id,
                                            @RequestBody EspecialidadeMedico especialidadeMedico){
        Optional<EspecialidadeMedico> checagem = repository.findById(id);
        if(checagem.isPresent()){
            try{
                repository.save(especialidadeMedico);
            } catch(IllegalArgumentException e){
                e.printStackTrace();
                ResponseEntity.badRequest().body("Dados inválidos!");
            }
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
