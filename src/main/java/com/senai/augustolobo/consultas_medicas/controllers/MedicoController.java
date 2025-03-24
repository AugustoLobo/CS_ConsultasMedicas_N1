package com.senai.augustolobo.consultas_medicas.controllers;

import com.senai.augustolobo.consultas_medicas.services.MedicoService;
import com.senai.augustolobo.consultas_medicas.entities.Medico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("medicos")
public class MedicoController {

    @Autowired
    private MedicoService medicoService;

    @GetMapping
    public List<Medico> findAll() {
        return medicoService.findAll();
    }

    @GetMapping("/{id}")
    public Medico findById(@PathVariable Integer id) {
        return medicoService.findById(id);
    }

    @PostMapping("/add")
    public Medico save(@RequestBody Medico medico) {
        return medicoService.saveMedico(medico);
    }

    @PutMapping("/att")
    public Medico update(@RequestBody Medico medico) {
        return medicoService.update(medico);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Integer id) {
        this.medicoService.delete(id);
    }
}
