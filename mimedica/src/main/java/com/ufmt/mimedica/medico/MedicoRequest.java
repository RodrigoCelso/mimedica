package com.ufmt.mimedica.medico;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MedicoRequest {

    private String nome;
    private int crm;

    public static Medico Request(MedicoRequest request){
        Medico medico = new Medico();
        medico.setNome(request.getNome());
        medico.setCrm(request.getCrm());
        return medico;
    }
}
