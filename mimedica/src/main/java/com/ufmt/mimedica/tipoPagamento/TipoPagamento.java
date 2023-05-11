package com.ufmt.mimedica.tipoPagamento;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.ufmt.mimedica.pagamento.Pagamento;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tipoPagamento")
@SequenceGenerator(name = "seqTipoPagamento", sequenceName = "seq_tipoPagamento_id", allocationSize = 1)
@Getter
@Setter
public class TipoPagamento {
    @Id
    @GeneratedValue(generator = "seqTipoPagamento", strategy = GenerationType.SEQUENCE)
    private int id;
    
    @Column
    private String tipo;

    @OneToMany(mappedBy = "tipoPagamentoId")
    private List<Pagamento> pagamentos;
}
