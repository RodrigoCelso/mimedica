package com.ufmt.mimedica.hospitalMedico;

import lombok.Data;

@Data
public class HospitalMedicoRequest {

    public static HospitalMedico Request(HospitalMedicoRequest request){
        HospitalMedico hospital = new HospitalMedico();
        return hospital;
    }
}
