package com.agileboard.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Prototipo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String enlace;

    // ✅ El campo correcto
    private String estadoValidacion; // "Pendiente", "Aprobado", "Rechazado"

    @ManyToMany
    @JoinTable(
        name = "prototipo_historias",
        joinColumns = @JoinColumn(name = "prototipo_id"),
        inverseJoinColumns = @JoinColumn(name = "historia_id")
    )
    private List<SprintBacklogItem> historias;

    @ManyToOne
    @JoinColumn(name = "proyecto_id")
    private Proyecto proyecto;

    // ✅ Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getEnlace() { return enlace; }
    public void setEnlace(String enlace) { this.enlace = enlace; }

    public String getEstadoValidacion() { return estadoValidacion; } // ✅ Getter correcto
    public void setEstadoValidacion(String estadoValidacion) { this.estadoValidacion = estadoValidacion; } // ✅ Setter correcto

    public List<SprintBacklogItem> getHistorias() { return historias; }
    public void setHistorias(List<SprintBacklogItem> historias) { this.historias = historias; }

    public Proyecto getProyecto() { return proyecto; }
    public void setProyecto(Proyecto proyecto) { this.proyecto = proyecto; }
}
