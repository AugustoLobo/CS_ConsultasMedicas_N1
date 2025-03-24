package com.senai.augustolobo.consultas_medicas.controllers;

import com.senai.augustolobo.consultas_medicas.services.PacienteService;
import com.senai.augustolobo.consultas_medicas.entities.Paciente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("pacientes")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @GetMapping
    public List<Paciente> findAll() {
        return pacienteService.findAll();
    }

    @GetMapping("/{id}")
    public Paciente findById(@PathVariable Integer id) {
        return pacienteService.findById(id);
    }

    @PostMapping("/add")
    public Paciente save(@RequestBody Paciente paciente) {
        return pacienteService.savePaciente(paciente);
    }

    @PutMapping("/att")
    public Paciente update(@RequestBody Paciente paciente) {
        return pacienteService.update(paciente);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Integer id) {
        this.pacienteService.delete(id);
    }
}
