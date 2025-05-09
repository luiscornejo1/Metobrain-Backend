
package com.agileboard.dto;

import com.agileboard.model.Tarea;
import com.agileboard.model.EstadoTarea;
import com.agileboard.model.Rol;
import com.agileboard.model.Sprint;
import com.agileboard.model.Proyecto;
import com.agileboard.model.Usuario;
import com.agileboard.repository.TareaRepository;
import com.agileboard.repository.SprintRepository;
import com.agileboard.repository.ProyectoRepository;
import com.agileboard.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class SprintCycleTimeDTO {
    private Long sprintId;
    private String sprintNombre;
    private double promedioCycleTime;

    public SprintCycleTimeDTO(Long sprintId, String sprintNombre, double promedioCycleTime) {
        this.sprintId = sprintId;
        this.sprintNombre = sprintNombre;
        this.promedioCycleTime = promedioCycleTime;
    }

    // Getters y setters

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

    public double getPromedioCycleTime() {
        return promedioCycleTime;
    }

    public void setPromedioCycleTime(double promedioCycleTime) {
        this.promedioCycleTime = promedioCycleTime;
    }


}
