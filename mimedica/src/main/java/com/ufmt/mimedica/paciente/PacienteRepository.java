package com.ufmt.mimedica.paciente;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

public interface PacienteRepository 
    extends JpaRepositoryImplementation<Paciente, Integer>{
    
}
