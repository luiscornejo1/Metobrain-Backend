package com.agileboard.model;

import jakarta.persistence.*;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.agileboard.model.Proyecto;   

@Entity
public class Proyecto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario owner;

    @OneToMany(mappedBy = "proyecto")
    private List<Sprint> sprints;

    // Getters y setters

     public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public Usuario getOwner() {
        return owner;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


}
