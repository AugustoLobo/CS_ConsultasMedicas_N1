package com.senai.augustolobo.consultas_medicas.services;

import com.senai.augustolobo.consultas_medicas.entities.Consulta;
import com.senai.augustolobo.consultas_medicas.entities.StatusConsulta;
import com.senai.augustolobo.consultas_medicas.repositories.ConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
public class ConsultaService {

    @Autowired
    private ConsultaRepository consultaRepository;

    public Consulta saveConsulta(Consulta consulta) {
        validarDisponibilidade(consulta);
        consulta.setStatus(StatusConsulta.AGENDADA);
        return consultaRepository.save(consulta);
    }

    public Consulta findById(int id) {
        return consultaRepository.findById(id).orElseThrow(() -> new RuntimeException("Consulta não encontrada"));
    }

    public List<Consulta> findAll() {
        return consultaRepository.findAll();
    }

    public void delete(int id) {
        consultaRepository.deleteById(id);
    }

    public Consulta update(Consulta consulta) {
        if (consultaRepository.existsById(consulta.getId())) {
            return consultaRepository.save(consulta);
        } else {
            throw new RuntimeException("Consulta não encontrada para atualização.");
        }
    }

    public void cancelarConsulta(int id) {
        Consulta consulta = consultaRepository.findById(id).orElseThrow(() -> new RuntimeException("Consulta não encontrada"));
        consulta.setStatus(StatusConsulta.CANCELADA);
        consultaRepository.save(consulta);
    }

    public void concluirConsulta(int id) {
        Consulta consulta = consultaRepository.findById(id).orElseThrow(() -> new RuntimeException("Consulta não encontrada"));
        consulta.setStatus(StatusConsulta.REALIZADA);
        consultaRepository.save(consulta);
    }

    private void validarDisponibilidade(Consulta consulta) {
        LocalDate data = consulta.getData();
        LocalTime horario = consulta.getHorario();

        boolean pacienteJaTemConsulta = consultaRepository.existsByPacienteIdAndDataAndHorario(consulta.getPaciente().getId(), data, horario);

        boolean medicoIndisponivel = consultaRepository.existsByMedicoIdAndDataAndHorario(consulta.getMedico().getId(), data, horario);

        if (pacienteJaTemConsulta) {
            throw new RuntimeException("O paciente já tem uma consulta nesse horário.");
        }

        if (medicoIndisponivel) {
            throw new RuntimeException("O médico já tem uma consulta agendada nesse horário.");
        }
    }

}
