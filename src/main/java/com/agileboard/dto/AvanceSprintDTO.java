package com.agileboard.dto;

public class AvanceSprintDTO {

    private Long sprintId;
    private String sprintNombre;
    private int totalTareas;
    private int tareasCompletadas;
    private double porcentajeAvance;

    public AvanceSprintDTO(Long sprintId, String sprintNombre, int totalTareas, int tareasCompletadas, double porcentajeAvance) {
        this.sprintId = sprintId;
        this.sprintNombre = sprintNombre;
        this.totalTareas = totalTareas;
        this.tareasCompletadas = tareasCompletadas;
        this.porcentajeAvance = porcentajeAvance;
    }

    public Long getSprintId() {
        return sprintId;
    }

    public void setSprintId(Long sprintId) {
        this.sprintId = sprintId;
    }

    public String getSprintNombre() {
        return sprintNombre;
    }

    public void setSprintNombre(String sprintNombre) {
        this.sprintNombre = sprintNombre;
    }

    public int getTotalTareas() {
        return totalTareas;
    }

    public void setTotalTareas(int totalTareas) {
        this.totalTareas = totalTareas;
    }

    public int getTareasCompletadas() {
        return tareasCompletadas;
    }

    public void setTareasCompletadas(int tareasCompletadas) {
        this.tareasCompletadas = tareasCompletadas;
    }

    public double getPorcentajeAvance() {
        return porcentajeAvance;
    }

    public void setPorcentajeAvance(double porcentajeAvance) {
        this.porcentajeAvance = porcentajeAvance;
    }
}
