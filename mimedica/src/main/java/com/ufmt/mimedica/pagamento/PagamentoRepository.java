package com.ufmt.mimedica.pagamento;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

public interface PagamentoRepository 
    extends JpaRepositoryImplementation<Pagamento, Integer>{
    
}
