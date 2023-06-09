package com.ufmt.mimedica.pagamento;

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
@RequestMapping(path="/pagamento")
@RequiredArgsConstructor
public class PagamentoController {

    private final PagamentoRepository repository;

    @GetMapping(path="/")
    public List<PagamentoResponse> index(){
        List<Pagamento> pagamentos = repository.findAll();

        List<PagamentoResponse> responses = new ArrayList<PagamentoResponse>();
        
        for(Pagamento pagamento : pagamentos) {
            responses.add(PagamentoResponse.response(pagamento));
        }

        return responses;
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<PagamentoResponse> getById(@PathVariable int id){
        Optional<Pagamento> found = repository.findById(id);

        if(found.isPresent()){
            PagamentoResponse response = PagamentoResponse.response(found.get());
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
    public ResponseEntity<String> cadastrar(@RequestBody PagamentoRequest request){        
        Pagamento dados = PagamentoRequest.request(request);

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
                                            @RequestBody PagamentoRequest request){
        Optional<Pagamento> checagem = repository.findById(id);
        if(checagem.isPresent()){
            Pagamento pagamento = PagamentoRequest.request(request);
            pagamento.setId(id);
            try{
                repository.save(pagamento);
            } catch(IllegalArgumentException e){
                e.printStackTrace();
                ResponseEntity.badRequest().body("Dados inválidos!");
            }
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
