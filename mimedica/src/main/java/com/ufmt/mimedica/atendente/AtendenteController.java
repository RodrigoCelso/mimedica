package com.ufmt.mimedica.atendente;

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
@RequestMapping(path="/atendente")
@RequiredArgsConstructor
public class AtendenteController {

    private final AtendenteRepository repository;

    @GetMapping(path="/")
    public List<AtendenteResponse> index(){
        List<Atendente> atendentes = repository.findAll();

        // Alternativamente:
        // atendentes.stream().map(AtendenteResponse::response).collect(Collectors.toList());

        List<AtendenteResponse> responses = new ArrayList<AtendenteResponse>();
        
        for(Atendente atendente : atendentes) {
            responses.add(AtendenteResponse.response(atendente));
        }

        return responses;
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<AtendenteResponse> getById(@PathVariable int id){
        Optional<Atendente> found = repository.findById(id);

        if(found.isPresent()){
            AtendenteResponse response = AtendenteResponse.response(found.get());
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
    public ResponseEntity<String> cadastrar(@RequestBody AtendenteRequest request){        
        Atendente dados = AtendenteRequest.request(request);

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
                                            @RequestBody AtendenteRequest request){
        Optional<Atendente> checagem = repository.findById(id);
        if(checagem.isPresent()){
            Atendente atendente = AtendenteRequest.request(request);
            atendente.setId(id);
            try{
                repository.save(atendente);
            } catch(IllegalArgumentException e){
                e.printStackTrace();
                ResponseEntity.badRequest().body("Dados inválidos!");
            }
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
