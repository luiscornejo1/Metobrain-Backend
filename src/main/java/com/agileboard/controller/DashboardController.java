
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
import com.agileboard.service.TareaService;
import com.agileboard.dto.SprintCycleTimeDTO;
import com.agileboard.dto.ConteoEstadoDTO;


import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;





@RestController
@RequestMapping("/api/dashboard")
@CrossOrigin
public class DashboardController {

    @Autowired
    private TareaService tareaService;

    @GetMapping("/cycle-time-promedio")
    public List<SprintCycleTimeDTO> promedioCycleTimePorSprint() {
        return tareaService.obtenerPromedioCycleTimePorSprint();
    }
    @GetMapping("/tareas-por-estado")
    public List<ConteoEstadoDTO> tareasPorEstadoGlobal() {
        return tareaService.contarTareasPorEstadoGlobal();
    }

    @GetMapping("/tareas-por-estado/sprint/{id}")
    public List<ConteoEstadoDTO> tareasPorEstadoPorSprint(@PathVariable Long id) {
        return tareaService.contarTareasPorEstadoPorSprint(id);
    }

    @GetMapping("/avance-por-sprint")
    public List<AvanceSprintDTO> avancePorSprint() {
        return tareaService.obtenerAvancePorSprint();
    }



}
