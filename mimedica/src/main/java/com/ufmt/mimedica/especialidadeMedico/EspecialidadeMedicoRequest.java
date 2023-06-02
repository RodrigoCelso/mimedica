package com.ufmt.mimedica.especialidadeMedico;

import lombok.Data;

@Data
public class EspecialidadeMedicoRequest {

    public static EspecialidadeMedico request(EspecialidadeMedicoRequest request){
        EspecialidadeMedico especialidadeMedico = new EspecialidadeMedico();
        
        return especialidadeMedico;
    }
}
