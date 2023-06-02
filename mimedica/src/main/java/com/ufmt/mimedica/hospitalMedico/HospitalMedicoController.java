package com.ufmt.mimedica.hospitalMedico;

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
@RequestMapping(path="/hospital-medico")
@RequiredArgsConstructor
public class HospitalMedicoController {

    private final HospitalMedicoRepository repository;

    @GetMapping(path="/")
    public List<HospitalMedicoResponse> index(){
        List<HospitalMedico> hospitalMedicos = repository.findAll();

        List<HospitalMedicoResponse> responses = new ArrayList<HospitalMedicoResponse>();
        
        for(HospitalMedico hospitalMedico : hospitalMedicos) {
            responses.add(HospitalMedicoResponse.response(hospitalMedico));
        }

        return responses;
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<HospitalMedicoResponse> getById(@PathVariable int id){
        Optional<HospitalMedico> found = repository.findById(id);

        if(found.isPresent()){
            HospitalMedicoResponse response = HospitalMedicoResponse.response(found.get());
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
    public ResponseEntity<String> cadastrar(@RequestBody HospitalMedicoRequest request){
        HospitalMedico hospitalMedico = HospitalMedicoRequest.request(request);

        try {
            repository.save(hospitalMedico);
        } catch(IllegalArgumentException e){
            e.printStackTrace();
            return ResponseEntity.badRequest().body("Dados Inválidos!");
        }

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PatchMapping(path = "/{id}")
    public ResponseEntity<String> atualizar(@PathVariable int id,
                                            @RequestBody HospitalMedicoRequest request){
        Optional<HospitalMedico> checagem = repository.findById(id);
        if(checagem.isPresent()){
            HospitalMedico hospitalMedico = HospitalMedicoRequest.request(request);
            hospitalMedico.setId(id);
            try{
                repository.save(hospitalMedico);
            } catch(IllegalArgumentException e){
                e.printStackTrace();
                ResponseEntity.badRequest().body("Dados inválidos!");
            }
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
