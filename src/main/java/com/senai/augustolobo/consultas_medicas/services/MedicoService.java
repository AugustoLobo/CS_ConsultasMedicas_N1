package com.senai.augustolobo.consultas_medicas.services;

import com.senai.augustolobo.consultas_medicas.entities.Medico;
import com.senai.augustolobo.consultas_medicas.repositories.MedicoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicoService {

    @Autowired
    private MedicoRepository medicoRepository;

    public Medico saveMedico(Medico medico) {
        return medicoRepository.save(medico);
    }

    public Medico findById(int id) {
        return medicoRepository.findById(id).orElseThrow(() -> new RuntimeException("Médico não encontrado"));
    }

    public List<Medico> findAll() {
        return medicoRepository.findAll();
    }

    public void delete(int id) {
        medicoRepository.deleteById(id);
    }

    public Medico update(Medico medico) {
        if (medicoRepository.existsById(medico.getId())) {
            return medicoRepository.save(medico);
        } else {
            throw new RuntimeException("Médico não encontrado para atualização.");
        }
    }
}
