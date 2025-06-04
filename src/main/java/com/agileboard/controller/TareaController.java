package com.agileboard.controller;

import com.agileboard.model.Tarea;
import com.agileboard.service.TareaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import com.agileboard.dto.ConteoEstadoDTO;


import java.util.List;

@RestController
@RequestMapping("/api/tareas")
@CrossOrigin
public class TareaController {

    @Autowired
    private TareaService tareaService;

    @GetMapping("/sprint/{sprintId}")
    public List<Tarea> listarTareasPorSprint(@PathVariable Long sprintId) {
        return tareaService.getTareasPorSprint(sprintId);
    }

    @GetMapping
    public List<Tarea> listarTodas() {
        return tareaService.listarTodas();
        }

    @PostMapping
    public Tarea crearTarea(@RequestBody Tarea tarea) {
        return tareaService.crearTarea(tarea);
    }

    @DeleteMapping("/{id}")
    public void eliminarTarea(@PathVariable Long id) {
        tareaService.eliminarTarea(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tarea> actualizarTarea(@PathVariable Long id, @RequestBody Tarea tarea) {
        return ResponseEntity.ok(tareaService.actualizarTarea(id, tarea));
    }



}
