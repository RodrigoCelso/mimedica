package com.ufmt.mimedica.plano;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlanoRequest {

    private int codigo;

    public static Plano Request(PlanoRequest request){
        Plano plano = new Plano();
        plano.setCodigo(request.getCodigo());
        return plano;
    }
}
