package com.ufmt.mimedica.hospitalMedico;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HospitalMedicoResponse {

    private int id;

    public static HospitalMedicoResponse response(HospitalMedico hospitalMedico){
        HospitalMedicoResponse response = new HospitalMedicoResponse();
        response.setId(hospitalMedico.getId());
        return response;
    }
}
