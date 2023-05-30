package com.ufmt.mimedica.pagamento;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PagamentoRequest {

    private float valor;

    public static Pagamento Request(PagamentoRequest request){
        Pagamento pagamento = new Pagamento();
        pagamento.setValor(request.getValor());
        return pagamento;
    }
}
