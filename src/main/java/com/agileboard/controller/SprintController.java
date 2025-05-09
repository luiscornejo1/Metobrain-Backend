package com.agileboard.controller;

import com.agileboard.model.Sprint;
import com.agileboard.service.SprintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.agileboard.dto.ConteoEstadoDTO;
import com.agileboard.service.TareaService;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.Map;
import com.agileboard.dto.SprintDTO;
import com.agileboard.model.Tarea;

import java.util.List;


@RestController
@RequestMapping("/api/sprints")
@CrossOrigin
public class SprintController {

    @Autowired
    private TareaService tareaService;
    
    @Autowired
    private SprintService sprintService;

    @GetMapping
    public List<Sprint> listarTodos() {
        return sprintService.listarTodos();
    }

    @GetMapping("/limpio")
    public List<SprintDTO> listarLimpios(){
        return sprintService.listarSprintsDTO();
    }

    @GetMapping("/proyecto/{proyectoId}")
    public List<Sprint> listarSprintsPorProyecto(@PathVariable Long proyectoId) {
        return sprintService.getSprintsPorProyecto(proyectoId);
    }

    @GetMapping("/tareas-por-estado/sprint/{id}")
    public List<ConteoEstadoDTO> tareasPorEstadoPorSprint(@PathVariable Long id) {
        return tareaService.contarTareasPorEstadoPorSprint(id);
    }


    @PostMapping
    public Sprint crearSprint(@RequestBody Sprint sprint) {
        return sprintService.crearSprint(sprint);
    }

    @DeleteMapping("/{id}")
    public void eliminarSprint(@PathVariable Long id) {
        sprintService.eliminarSprint(id);
    }
}
