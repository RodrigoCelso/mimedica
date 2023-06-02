package com.ufmt.mimedica.hospital;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HospitalRequest {

    private String nome;
    private String cnpj;

    public static Hospital request(HospitalRequest request){
        Hospital hospital = new Hospital();
        hospital.setNome(request.getNome());
        hospital.setCnpj(request.getCnpj());
        return hospital;
    }
}
