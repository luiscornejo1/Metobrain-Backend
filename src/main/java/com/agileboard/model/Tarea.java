package com.agileboard.model;

import jakarta.persistence.*;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Tarea {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String descripcion;

    @Enumerated(EnumType.STRING)
    private EstadoTarea estado;

    private Long cycleTime; // en minutos u horas

    @ManyToOne
    @JoinColumn(name = "sprint_id")
    private Sprint sprint;


    private Long startTime = System.currentTimeMillis();
    public Long getStartTime() {
        return startTime;
    }
    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }


    // Getters y setters
     public Long getId() { return id; }

    public String getTitulo() { return titulo; }

    public String getDescripcion() { return descripcion; }

    public EstadoTarea getEstado() { return estado; }

    public Long getCycleTime() { return cycleTime; }

    public Sprint getSprint() { return sprint; }

    public void setId(Long id) { this.id = id; }

    public void setTitulo(String titulo) { this.titulo = titulo; }

    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public void setEstado(EstadoTarea estado) { this.estado = estado; }

    public void setCycleTime(Long cycleTime) { this.cycleTime = cycleTime; }

    public void setSprint(Sprint sprint) { this.sprint = sprint; }
}
