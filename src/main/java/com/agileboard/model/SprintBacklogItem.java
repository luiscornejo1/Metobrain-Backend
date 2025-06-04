package com.agileboard.model;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.LocalDateTime;
import java.util.List;


@Entity
public class SprintBacklogItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String descripcion;

    @Column(length = 20)
    private String prioridadMoscow; // Must, Should, Could, Won't

    @Column(length = 20)
    private String estado = "Por hacer"; // Por hacer, En progreso, Hecho

    @ManyToMany(mappedBy = "historias")
    @JsonIgnore
    private List<Prototipo> prototipos;

    @ManyToOne
    @JoinColumn(name = "proyecto_id")
    private Proyecto proyecto;

    @ManyToOne
    @JoinColumn(name = "product_backlog_id")
    private BacklogItem productBacklogItem; // Opcional: para vincularlo con el Product Backlog

    // ✅ Nuevo: campo que usas para vincular con la HU
    @ManyToOne
    @JoinColumn(name = "backlog_item_id")
    private BacklogItem backlogItem;

    private LocalDateTime createdAt = LocalDateTime.now();

    // Getters y Setters
    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getDescripcion() { return descripcion; }

    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public String getPrioridadMoscow() { return prioridadMoscow; }

    public void setPrioridadMoscow(String prioridadMoscow) { this.prioridadMoscow = prioridadMoscow; }

    public String getEstado() { return estado; }

    public void setEstado(String estado) { this.estado = estado; }

    public Proyecto getProyecto() { return proyecto; }

    public void setProyecto(Proyecto proyecto) { this.proyecto = proyecto; }

    public BacklogItem getProductBacklogItem() { return productBacklogItem; }

    public void setProductBacklogItem(BacklogItem productBacklogItem) { this.productBacklogItem = productBacklogItem; }

    // ✅ Getters y setters para el nuevo campo backlogItem
    public BacklogItem getBacklogItem() { return backlogItem; }

    public void setBacklogItem(BacklogItem backlogItem) { this.backlogItem = backlogItem; }

    public LocalDateTime getCreatedAt() { return createdAt; }

    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public List<Prototipo> getPrototipos() { return prototipos; }

    public void setPrototipos(List<Prototipo> prototipos) { 
        this.prototipos = prototipos;

    }
}
