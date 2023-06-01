package com.ufmt.mimedica.tipoPagamento;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TipoPagamentoRequest {

    private String tipo;

    public static TipoPagamento Request(TipoPagamentoRequest request){
        TipoPagamento pagamento = new TipoPagamento();
        pagamento.setTipo(request.getTipo());
        return pagamento;
    }
}
