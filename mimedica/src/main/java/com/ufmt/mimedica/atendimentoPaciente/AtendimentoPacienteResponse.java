package com.ufmt.mimedica.atendimentoPaciente;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AtendimentoPacienteResponse {

    private int id;

    public static AtendimentoPacienteResponse Response(AtendimentoPaciente atendimentoPaciente){
        AtendimentoPacienteResponse response = new AtendimentoPacienteResponse();
        response.setId(atendimentoPaciente.getId());
        return response;
    }
}
