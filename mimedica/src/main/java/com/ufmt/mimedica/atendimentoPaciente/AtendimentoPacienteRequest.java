package com.ufmt.mimedica.atendimentoPaciente;

import lombok.Data;

@Data
public class AtendimentoPacienteRequest {
    public static AtendimentoPaciente Request(AtendimentoPacienteRequest request){
        AtendimentoPaciente atendimentoPaciente = new AtendimentoPaciente();
        return atendimentoPaciente;
    }
}
