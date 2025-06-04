package com.agileboard.dto;

public class SprintDTO {
    private Long id;
    private String nombre;
    private String fechaInicio;
    private String fechaFin;
    private Long proyectoId;
    private String proyectoNombre;

    public SprintDTO(Long id, String nombre, String fechaInicio, String fechaFin, Long proyectoId, String proyectoNombre) {
        this.id = id;
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.proyectoId = proyectoId;
        this.proyectoNombre = proyectoNombre;
    }

    // Getters y setters aquí...

            public Long getId() {
            return id;
        }
    
        public void setId(Long id) {
            this.id = id;
        }
    
        public String getNombre() {
            return nombre;
        }
    
        public void setNombre(String nombre) {
            this.nombre = nombre;
        }
    
        public String getFechaInicio() {
            return fechaInicio;
        }
    
        public void setFechaInicio(String fechaInicio) {
            this.fechaInicio = fechaInicio;
        }
    
        public String getFechaFin() {
            return fechaFin;
        }
    
        public void setFechaFin(String fechaFin) {
            this.fechaFin = fechaFin;
        }
}
    
    
