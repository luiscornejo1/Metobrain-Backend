package com.agileboard.controller;

import com.agileboard.model.Proyecto;
import com.agileboard.service.ProyectoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.agileboard.dto.ConteoEstadoDTO;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/proyectos")
@CrossOrigin
public class ProyectoController {

    @Autowired
    private ProyectoService proyectoService;

    @GetMapping
    public List<Proyecto> listarTodos() {
        return proyectoService.getTodosLosProyectos();
    }


    @GetMapping("/usuario/{usuarioId}")
    public List<Proyecto> listarProyectosPorUsuario(@PathVariable Long usuarioId) {
        return proyectoService.getProyectosPorUsuario(usuarioId);
    }

    @GetMapping("/{id}")
    public Optional<Proyecto> obtenerProyecto(@PathVariable Long id) {
        return proyectoService.getProyectoById(id);
    }

    @PostMapping
    public Proyecto crearProyecto(@RequestBody Proyecto proyecto) {
        return proyectoService.crearProyecto(proyecto);
    }

    @DeleteMapping("/{id}")
    public void eliminarProyecto(@PathVariable Long id) {
        proyectoService.eliminarProyecto(id);
    }
}
