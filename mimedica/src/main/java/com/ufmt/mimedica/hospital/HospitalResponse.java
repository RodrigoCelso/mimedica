package com.ufmt.mimedica.hospital;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HospitalResponse {

    private int id;
    private String nome;
    private String cnpj;

    public static HospitalResponse Response(Hospital hospital){
        HospitalResponse response = new HospitalResponse();
        response.setId(hospital.getId());
        response.setNome(hospital.getNome());
        response.setCnpj(hospital.getCnpj());
        return response;
    }
}
