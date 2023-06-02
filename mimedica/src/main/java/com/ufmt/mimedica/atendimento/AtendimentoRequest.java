package com.ufmt.mimedica.atendimento;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AtendimentoRequest {

    private Date data;

    public static Atendimento request(AtendimentoRequest request){
        Atendimento atendimento = new Atendimento();
        atendimento.setData(request.getData());
        return atendimento;
    }
}
