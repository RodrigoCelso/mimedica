package com.ufmt.mimedica.especialidadeMedico;

import lombok.Data;

@Data
public class EspecialidadeMedicoRequest {

    public static EspecialidadeMedico Request(EspecialidadeMedicoRequest request){
        EspecialidadeMedico especialidadeMedico = new EspecialidadeMedico();
        return especialidadeMedico;
    }
}
