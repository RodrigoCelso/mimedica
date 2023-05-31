package com.ufmt.mimedica.paciente;

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
@RequestMapping(path="/paciente")
@RequiredArgsConstructor
public class PacienteController {

    private final PacienteRepository repository;

    @GetMapping(path="/")
    public List<Paciente> index(){
        return repository.findAll();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<PacienteResponse> getById(@PathVariable int id){
        Optional<Paciente> found = repository.findById(id);

        if(found.isPresent()){
            PacienteResponse response = PacienteResponse.Response(found.get());
            return ResponseEntity.ok().body(response);
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
    public ResponseEntity<String> cadastrar(@RequestBody PacienteRequest request){        
        Paciente dados = PacienteRequest.Request(request);

        try {
            repository.save(dados);
        } catch(IllegalArgumentException e){
            e.printStackTrace();
            return ResponseEntity.badRequest().body("Dados Inválidos!");
        }

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PatchMapping(path = "/{id}")
    public ResponseEntity<String> atualizar(@PathVariable int id,
                                            @RequestBody PacienteRequest request){
        Optional<Paciente> checagem = repository.findById(id);
        if(checagem.isPresent()){
            Paciente paciente = PacienteRequest.Request(request);
            try{
                repository.save(paciente);
            } catch(IllegalArgumentException e){
                e.printStackTrace();
                ResponseEntity.badRequest().body("Dados inválidos!");
            }
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
