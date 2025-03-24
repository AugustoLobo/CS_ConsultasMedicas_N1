package com.senai.augustolobo.consultas_medicas.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "Medico")
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String especialidade;

    @Column(nullable = false)
    private Integer crm;

    @OneToMany(mappedBy = "medico")
    @JsonBackReference
    private List<Consulta> consultas;

    public Medico() {
    }

    public Medico(Integer id, String nome, String especialidade, Integer crm, List<Consulta> consultas) {
        this.id = id;
        this.nome = nome;
        this.especialidade = especialidade;
        this.crm = crm;
        this.consultas = consultas;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public Integer getCrm() {
        return crm;
    }

    public void setCrm(Integer crm) {
        this.crm = crm;
    }

    public List<Consulta> getConsultas() {
        return consultas;
    }

    public void setConsultas(List<Consulta> consultas) {
        this.consultas = consultas;
    }

}
