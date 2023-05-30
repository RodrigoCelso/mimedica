package com.ufmt.mimedica.especialidade;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EspecialidadeResponse {

    private int id;
    private String tipo;

    public static EspecialidadeResponse Response(Especialidade especialidade){
        EspecialidadeResponse response = new EspecialidadeResponse();
        response.setId(especialidade.getId());
        response.setTipo(especialidade.getTipo());
        return response;
    }
}
