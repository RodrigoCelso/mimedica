package com.ufmt.mimedica.especialidadeMedico;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EspecialidadeMedicoResponse {

    private int id;

    public static EspecialidadeMedicoResponse Response(EspecialidadeMedico especialidadeMedico){
        EspecialidadeMedicoResponse response = new EspecialidadeMedicoResponse();
        response.setId(especialidadeMedico.getId());
        return response;
    }
}
