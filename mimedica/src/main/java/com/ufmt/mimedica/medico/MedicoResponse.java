package com.ufmt.mimedica.medico;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MedicoResponse {

    private int id;
    private String nome;
    private int crm;

    public static MedicoResponse Response(Medico medico){
        MedicoResponse response = new MedicoResponse();
        response.setId(medico.getId());
        response.setNome(medico.getNome());
        response.setCrm(medico.getCrm());
        return response;
    }
}
