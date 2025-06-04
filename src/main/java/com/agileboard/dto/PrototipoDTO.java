package com.agileboard.dto;

import java.util.List;
import com.agileboard.model.Proyecto;

public class PrototipoDTO {
    private String nombre;
    private String enlace;
    private List<Long> historiasIds;
    private Proyecto proyecto;

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getEnlace() {
        return enlace;
    }
    public void setEnlace(String enlace) {
        this.enlace = enlace;
    }
    public List<Long> getHistoriasIds() {
        return historiasIds;
    }
    public void setHistoriasIds(List<Long> historiasIds) {
        this.historiasIds = historiasIds;
    }
    public Proyecto getProyecto() {
        return proyecto;
    }
    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }

    // ...
}
