package com.ufmt.mimedica.plano;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlanoResponse {

    private int id;
    private int codigo;

    public static PlanoResponse Response(Plano plano){
        PlanoResponse response = new PlanoResponse();
        response.setId(plano.getId());
        response.setCodigo(plano.getCodigo());
        return response;
    }
}
