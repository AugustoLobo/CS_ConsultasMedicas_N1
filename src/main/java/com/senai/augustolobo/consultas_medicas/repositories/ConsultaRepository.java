package com.senai.augustolobo.consultas_medicas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.senai.augustolobo.consultas_medicas.entities.Consulta;
import java.time.LocalDate;
import java.time.LocalTime;

public interface ConsultaRepository extends JpaRepository<Consulta, Integer> {

    boolean existsByPacienteIdAndDataAndHorario(Integer pacienteId, LocalDate data, LocalTime horario);

    boolean existsByMedicoIdAndDataAndHorario(Integer medicoId, LocalDate data, LocalTime horario);

}
