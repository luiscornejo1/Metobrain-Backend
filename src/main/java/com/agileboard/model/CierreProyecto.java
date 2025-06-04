package com.agileboard.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class CierreProyecto{

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

private String entregable;

private String aceptacionCliente;

@Column(columnDefinition = "TEXT")
private String leccionesAprendidas;

private LocalDateTime fecha = LocalDateTime.now();

@ManyToOne
@JoinColumn(name = "proyecto_id")
private Proyecto proyecto;

// Getters y Setters
public Long getId() { return id; }

public String getEntregable() { return entregable; }
public void setEntregable(String entregable) { this.entregable = entregable; }

public String getAceptacionCliente() { return aceptacionCliente; }
public void setAceptacionCliente(String aceptacionCliente) { this.aceptacionCliente = aceptacionCliente; }

public String getLeccionesAprendidas() { return leccionesAprendidas; }
public void setLeccionesAprendidas(String leccionesAprendidas) { this.leccionesAprendidas = leccionesAprendidas; }

public LocalDateTime getFecha() { return fecha; }
public void setFecha(LocalDateTime fecha) { this.fecha = fecha; }

public Proyecto getProyecto() { return proyecto; }
public void setProyecto(Proyecto proyecto) { this.proyecto = proyecto; }

}