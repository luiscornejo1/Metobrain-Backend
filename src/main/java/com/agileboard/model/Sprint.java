package com.agileboard.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.agileboard.model.Proyecto;

@Entity
public class Sprint {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;

    @ManyToOne
    @JoinColumn(name = "proyecto_id")
    private Proyecto proyecto;

    @OneToMany(mappedBy = "sprint")
    private List<Tarea> tareas;

    // Getters y setters

    public Long getId() { return id; }

    public String getNombre() { return nombre; }

    public LocalDate getFechaInicio() { return fechaInicio; }

    public LocalDate getFechaFin() { return fechaFin; }

    public Proyecto getProyecto() { return proyecto; }

    public void setId(Long id) { this.id = id; }

    public void setNombre(String nombre) { this.nombre = nombre; }

    public void setFechaInicio(LocalDate fechaInicio) { this.fechaInicio = fechaInicio; }

    public void setFechaFin(LocalDate fechaFin) { this.fechaFin = fechaFin; }

    public void setProyecto(Proyecto proyecto) { this.proyecto = proyecto; }
}
