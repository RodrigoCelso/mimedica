package com.ufmt.mimedica.hospital;

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
@RequestMapping(path="/hospital")
@RequiredArgsConstructor
public class HospitalController {

    private final HospitalRepository repository;

    @GetMapping(path="/")
    public List<Hospital> index(){
        return repository.findAll();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<HospitalResponse> getById(@PathVariable int id){
        Optional<Hospital> found = repository.findById(id);

        if(found.isPresent()){
            HospitalResponse response = HospitalResponse.Response(found.get());
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
    public ResponseEntity<String> cadastrar(@RequestBody HospitalRequest request){        
        Hospital dados = HospitalRequest.Request(request);

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
                                            @RequestBody HospitalRequest request){
        Optional<Hospital> checagem = repository.findById(id);
        if(checagem.isPresent()){
            Hospital hospital = HospitalRequest.Request(request);
            try{
                repository.save(hospital);
            } catch(IllegalArgumentException e){
                e.printStackTrace();
                ResponseEntity.badRequest().body("Dados inválidos!");
            }
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
