package com.senai.augustolobo.consultas_medicas.services;

import com.senai.augustolobo.consultas_medicas.entities.Paciente;
import com.senai.augustolobo.consultas_medicas.repositories.PacienteRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    public Paciente savePaciente(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    public Paciente findById(int id) {
        return pacienteRepository.findById(id).orElseThrow(() -> new RuntimeException("Paciente não encontrado"));
    }

    public List<Paciente> findAll() {
        return pacienteRepository.findAll();
    }

    public void delete(int id) {
        pacienteRepository.deleteById(id);
    }

    public Paciente update(Paciente paciente) {
        if (pacienteRepository.existsById(paciente.getId())) {
            return pacienteRepository.save(paciente);
        } else {
            throw new RuntimeException("Paciente não encontrado para atualização.");
        }
    }
}
