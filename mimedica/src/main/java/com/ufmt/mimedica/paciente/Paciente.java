package com.ufmt.mimedica.paciente;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.ufmt.mimedica.atendimentoPaciente.AtendimentoPaciente;
import com.ufmt.mimedica.pagamento.Pagamento;
import com.ufmt.mimedica.plano.Plano;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "paciente")
@SequenceGenerator(name = "seqPaciente", sequenceName = "seq_paciente_id", allocationSize = 1)
@Getter
@Setter
public class Paciente {
    @Id
    @GeneratedValue(generator = "seqPaciente", strategy = GenerationType.SEQUENCE)
    private int id;
    
    @Column
    private String nome;
    
    @Column
    private int cpf;
    
    @Column
    private int cep;
    
    @Column
    private String complemento;
    
    @ManyToOne
    @JoinColumn(name = "plano_id")
    private Plano planoId;

    @OneToMany(mappedBy = "pacienteId")
    private List<AtendimentoPaciente> atendimentoPacientes;

    @OneToMany(mappedBy = "pacienteId")
    private List<Pagamento> pagamentos;
}
