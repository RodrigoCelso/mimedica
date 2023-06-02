package com.ufmt.mimedica.pagamento;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PagamentoResponse {

    private int id;
    private float valor;

    public static PagamentoResponse response(Pagamento pagamento){
        PagamentoResponse response = new PagamentoResponse();
        response.setId(pagamento.getId());
        response.setValor(pagamento.getValor());
        return response;
    }
}
