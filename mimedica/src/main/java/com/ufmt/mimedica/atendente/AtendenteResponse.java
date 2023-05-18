package com.ufmt.mimedica.atendente;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AtendenteResponse {
    private int id;
    private String nome;
    private int cpf;

    public static AtendenteResponse from(Atendente entidade){
        AtendenteResponse response = new AtendenteResponse();
        response.setId(entidade.getId());
        response.setNome(entidade.getNome());
        response.setCpf(entidade.getCpf());
        return response;
    }
}