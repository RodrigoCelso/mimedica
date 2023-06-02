package com.ufmt.mimedica.especialidadeMedico;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EspecialidadeMedicoResponse {

    private int id;

    public static EspecialidadeMedicoResponse response(EspecialidadeMedico atendimento){
        EspecialidadeMedicoResponse response = new EspecialidadeMedicoResponse();
        response.setId(atendimento.getId());

        return response;
    }
}
