package com.ufmt.mimedica.tipoPagamento;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TipoPagamentoResponse {

    private int id;
    private String tipo;

    public static TipoPagamentoResponse Response(TipoPagamento tipoPagamento){
        TipoPagamentoResponse response = new TipoPagamentoResponse();
        response.setId(tipoPagamento.getId());
        response.setTipo(tipoPagamento.getTipo());
        return response;
    }
}
