package com.ufmt.mimedica.hospital;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

public interface HospitalRepository 
    extends JpaRepositoryImplementation<Hospital, Integer>{
    
}
