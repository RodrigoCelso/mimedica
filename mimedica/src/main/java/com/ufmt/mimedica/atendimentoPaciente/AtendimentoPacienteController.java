package com.ufmt.mimedica.atendimentoPaciente;

import java.util.ArrayList;
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
@RequestMapping(path="/atendimento-paciente")
@RequiredArgsConstructor
public class AtendimentoPacienteController {

    private final AtendimentoPacienteRepository repository;

    @GetMapping(path="/")
    public List<AtendimentoPacienteResponse> index(){
        List<AtendimentoPaciente> atendimentoPacientes = repository.findAll();

        List<AtendimentoPacienteResponse> responses = new ArrayList<AtendimentoPacienteResponse>();
        
        for(AtendimentoPaciente atendimentoPaciente : atendimentoPacientes) {
            responses.add(AtendimentoPacienteResponse.response(atendimentoPaciente));
        }

        return responses;
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<AtendimentoPacienteResponse> getById(@PathVariable int id){
        Optional<AtendimentoPaciente> found = repository.findById(id);

        if(found.isPresent()){
            AtendimentoPacienteResponse response = AtendimentoPacienteResponse.response(found.get());
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
    public ResponseEntity<String> cadastrar(@RequestBody AtendimentoPacienteRequest request){  
        AtendimentoPaciente dados = AtendimentoPacienteRequest.request(request);
        
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
                                            @RequestBody AtendimentoPacienteRequest request){
        Optional<AtendimentoPaciente> checagem = repository.findById(id);
        if(checagem.isPresent()){
            AtendimentoPaciente atendimentoPaciente = AtendimentoPacienteRequest.request(request);
            atendimentoPaciente.setId(id);
            try{
                repository.save(atendimentoPaciente);
            } catch(IllegalArgumentException e){
                e.printStackTrace();
                ResponseEntity.badRequest().body("Dados inválidos!");
            }
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
