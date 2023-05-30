package com.ufmt.mimedica.atendimento;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AtendimentoResponse {

    private int id;
    private Date data;

    public static AtendimentoResponse Response(Atendimento atendimento){
        AtendimentoResponse response = new AtendimentoResponse();
        response.setId(atendimento.getId());
        response.setData(atendimento.getData());
        return response;
    }
}
