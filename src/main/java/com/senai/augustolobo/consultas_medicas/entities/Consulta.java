package com.senai.augustolobo.consultas_medicas.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "Consulta")
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false)
    private LocalDate data;

    @Column(nullable = false)
    private LocalTime horario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "medico_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Medico medico;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "paciente_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Paciente paciente;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusConsulta status;

    public Consulta() {
    }

    public Consulta(LocalDate data, LocalTime horario, Medico medico, Paciente paciente, StatusConsulta status) {
        this.data = data;
        this.horario = horario;
        this.medico = medico;
        this.paciente = paciente;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public LocalTime getHorario() {
        return horario;
    }

    public void setHorario(LocalTime horario) {
        this.horario = horario;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public StatusConsulta getStatus() {
        return status;
    }

    public void setStatus(StatusConsulta status) {
        this.status = status;
    }
    
}
