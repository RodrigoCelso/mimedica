package com.ufmt.mimedica.hospitalMedico;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.ufmt.mimedica.hospital.Hospital;
import com.ufmt.mimedica.medico.Medico;

@Entity
@Table(name = "hospitalMedico")
@SequenceGenerator(name = "seqHospitalMedico", sequenceName = "seq_hospitalMedico_id", allocationSize = 1)
@lombok.Getter
@lombok.Setter
public class HospitalMedico {
    @Id
    @GeneratedValue(generator = "seqHospitalMedico")
    private int id;
    @ManyToOne
    @JoinColumn(name = "hospital_id")
    private Hospital hospitalId;
    @ManyToOne
    @JoinColumn(name = "medico_id")
    private Medico medicoId;
}
