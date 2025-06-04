
package com.agileboard.model;



import jakarta.persistence.*;
import java.util.List;
import com.agileboard.model.Sprint;



@Entity
public class Retrospectiva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String contenido;

    @ManyToOne
    @JoinColumn(name = "sprint_id")
    private Sprint sprint;

    // Getters y setters

    public Long getId() {
        return id;
    }
    public String getContenido() {
        return contenido;
    }
    public Sprint getSprint() {
        return sprint;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public void setContenido(String contenido) {
        this.contenido = contenido;
    }
    public void setSprint(Sprint sprint) {
        this.sprint = sprint;
    }

}
