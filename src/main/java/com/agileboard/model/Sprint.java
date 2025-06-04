package com.agileboard.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;
import com.agileboard.model.Proyecto;

@Entity
public class Sprint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;

    @Column(nullable = false)
    private boolean cerrado = false; // NUEVO CAMPO AGREGADO

    @ManyToOne
    @JoinColumn(name = "proyecto_id")
    private Proyecto proyecto;

    @OneToMany(mappedBy = "sprint")
    private List<Tarea> tareas;

    // Getters y setters

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public boolean isCerrado() {
        return cerrado;
    }

    public Proyecto getProyecto() {
        return proyecto;
    }

    public List<Tarea> getTareas() {
        return tareas;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }

    public void setTareas(List<Tarea> tareas) {
        this.tareas = tareas;
    }

    public void setCerrado(boolean cerrado) {
        this.cerrado = cerrado;
    }
}
