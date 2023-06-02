package com.ufmt.mimedica.paciente;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PacienteResponse {

    private int id;
    private String nome;
    private String cpf;
    private String cep;
    private String complemento;

    public static PacienteResponse response(Paciente paciente){
        PacienteResponse response = new PacienteResponse();
        response.setId(paciente.getId());
        response.setNome(paciente.getNome());
        response.setCpf(paciente.getCpf());
        response.setCep(paciente.getCep());
        response.setComplemento(paciente.getComplemento());
        return response;
    }
}
