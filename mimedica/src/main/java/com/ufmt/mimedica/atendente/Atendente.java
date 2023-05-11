package com.ufmt.mimedica.atendente;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.ufmt.mimedica.atendimento.Atendimento;
import com.ufmt.mimedica.pagamento.Pagamento;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "atendente")
@SequenceGenerator(name = "seqAtendente", sequenceName = "seq_atendente_id", allocationSize = 1)
@Getter
@Setter
public class Atendente {
    @Id
    @GeneratedValue(generator = "seqAtendente", strategy = GenerationType.SEQUENCE)
    private int id;
    
    @Column
    private String nome;
    
    @Column
    private int cpf;

    @OneToMany(mappedBy = "atendenteId")
    private List<Atendimento> atendimentos;

    @OneToMany(mappedBy = "atendenteId")
    private List<Pagamento> pagamentos;
}
