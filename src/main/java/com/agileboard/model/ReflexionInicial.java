package com.agileboard.model;

import jakarta.persistence.*;

@Entity
public class ReflexionInicial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
   @Column(columnDefinition = "TEXT")
    private String ikigai;
    
    @Column(columnDefinition = "TEXT")
    private String entrevistas;

    @Column(columnDefinition = "TEXT")
    private String mapaEmpatia;
    
    
    @ManyToOne
    @JoinColumn(name = "proyecto_id")
    private Proyecto proyecto;

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public String getIkigai() {
        return ikigai;
    }

    public String getEntrevistas() {
        return entrevistas;
    }

    public String getMapaEmpatia() {
        return mapaEmpatia;
    }

    public Proyecto getProyecto() {
        return proyecto;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setIkigai(String ikigai) {
        this.ikigai = ikigai;
    }

    public void setEntrevistas(String entrevistas) {
        this.entrevistas = entrevistas;
    }

    public void setMapaEmpatia(String mapaEmpatia) {
        this.mapaEmpatia = mapaEmpatia;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }
}
