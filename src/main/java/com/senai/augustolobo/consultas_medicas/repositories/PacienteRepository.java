package com.senai.augustolobo.consultas_medicas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.senai.augustolobo.consultas_medicas.entities.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, Integer> {

}
