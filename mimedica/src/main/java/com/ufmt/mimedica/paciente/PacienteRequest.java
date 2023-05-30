package com.ufmt.mimedica.paciente;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PacienteRequest {

    private String nome;
    private String cpf;
    private String cep;
    private String complemento;

    public static Paciente Request(PacienteRequest request){
        Paciente paciente = new Paciente();
        paciente.setNome(request.getNome());
        paciente.setCpf(request.getCpf());
        paciente.setCep(request.getCep());
        paciente.setComplemento(request.getComplemento());
        return paciente;
    }
}
