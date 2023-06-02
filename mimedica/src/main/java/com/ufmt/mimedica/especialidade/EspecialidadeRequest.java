package com.ufmt.mimedica.especialidade;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EspecialidadeRequest {

    private String tipo;

    public static Especialidade request(EspecialidadeRequest request){
        Especialidade especialidade = new Especialidade();
        especialidade.setTipo(request.getTipo());
        return especialidade;
    }
}
