package com.agileboard.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class BacklogItem {

    @Column
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column
    private LocalDateTime startedAt;

    @Column
    private LocalDateTime completedAt;

    @Column
    private Integer storyPoints;

    @Column(length = 50) 
    private String prioridad;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "proyecto_id")
    private Proyecto proyecto;

    @Column(length = 255)
    private String responsable;

    @Column(length = 50)
    private String estado = "Por hacer"; // Valor por defecto

    @Column(length = 255)
    private String epica;




    // Getters y Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Proyecto getProyecto() {
        return proyecto;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad; 
    }    

    public Integer getStoryPoints() {
        return storyPoints;
    }
    
    public void setStoryPoints(Integer storyPoints) {
        
        this.storyPoints = storyPoints;
    
    }
    public String getResponsable() {
        return responsable;
    }
    
    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public String getEstado() {
        return estado;
        
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public String getEpica() {
        return epica;
    }
    
    public void setEpica(String epica) {
        this.epica = epica;
    }

     public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getStartedAt() {
        return startedAt;
    }

    public void setStartedAt(LocalDateTime startedAt) {
        this.startedAt = startedAt;
    }

    public LocalDateTime getCompletedAt() {
        return completedAt;
    }

    public void setCompletedAt(LocalDateTime completedAt) {
        this.completedAt = completedAt;
    }





} 
