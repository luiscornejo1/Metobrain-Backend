package com.agileboard.model;

import jakarta.persistence.*;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.agileboard.model.Proyecto;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String email;
    private String password;

    @Enumerated(EnumType.STRING)
    private Rol rol;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Proyecto> proyectos;

    // Getters y setters

    public Long getId() {
    return id;
}

public String getNombre() {
    return nombre;
}

public String getEmail() {
    return email;
}

public String getPassword() {
    return password;
}

public Rol getRol() {
    return rol;
}

}
