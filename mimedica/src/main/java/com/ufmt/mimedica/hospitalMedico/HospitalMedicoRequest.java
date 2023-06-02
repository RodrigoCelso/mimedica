package com.ufmt.mimedica.hospitalMedico;

import lombok.Data;

@Data
public class HospitalMedicoRequest {
    public static HospitalMedico request(HospitalMedicoRequest request){
        HospitalMedico hospitalMedico = new HospitalMedico();
        
        return hospitalMedico;
    }
}
