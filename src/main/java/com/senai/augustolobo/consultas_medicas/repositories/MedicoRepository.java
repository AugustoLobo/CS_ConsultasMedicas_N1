package com.senai.augustolobo.consultas_medicas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.senai.augustolobo.consultas_medicas.entities.Medico;

public interface MedicoRepository extends JpaRepository<Medico, Integer> {

}
