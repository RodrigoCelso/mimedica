package com.ufmt.mimedica.atendente;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AtendenteRequest {
    private String nome;
    private int cpf;

    public static Atendente transcribe(AtendenteRequest entidade){
        Atendente request = new Atendente();
        request.setNome(entidade.getNome());
        request.setCpf(entidade.getCpf());
        return request;
    }
}