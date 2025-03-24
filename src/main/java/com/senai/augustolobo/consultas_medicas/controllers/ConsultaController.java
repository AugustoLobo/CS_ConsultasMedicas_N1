package com.senai.augustolobo.consultas_medicas.controllers;

import com.senai.augustolobo.consultas_medicas.services.ConsultaService;
import com.senai.augustolobo.consultas_medicas.entities.Consulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("consultas")
public class ConsultaController {

    @Autowired
    private ConsultaService consultaService;

    @GetMapping
    public List<Consulta> findAll() {
        return consultaService.findAll();
    }

    @GetMapping("/{id}")
    public Consulta findById(@PathVariable Integer id) {
        return consultaService.findById(id);
    }

    @PostMapping("/add")
    public Consulta save(@RequestBody Consulta consulta) {
        return consultaService.saveConsulta(consulta);
    }

    @PutMapping("/att")
    public Consulta update(@RequestBody Consulta consulta) {
        return consultaService.update(consulta);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Integer id) {
        this.consultaService.delete(id);
    }

    @PutMapping("/concluir/{id}")
    public void concluir(@PathVariable Integer id) {
        consultaService.concluirConsulta(id);
    }
    
    @PutMapping("/cancelar/{id}")
    public void cancelar(@PathVariable Integer id) {
        consultaService.cancelarConsulta(id);
    }
}
