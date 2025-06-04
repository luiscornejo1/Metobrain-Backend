package com.agileboard.controller;

import com.agileboard.model.ReflexionInicial;
import com.agileboard.service.ReflexionInicialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reflexiones")
@CrossOrigin(origins = "http://localhost:5173")
public class ReflexionInicialController {

    @Autowired
    private ReflexionInicialService service;

    @PostMapping
    public ReflexionInicial guardar(@RequestBody ReflexionInicial reflexion) {
        return service.guardar(reflexion);
    }
    
    @PutMapping("/{id}")
    public ReflexionInicial actualizar(@PathVariable Long id, @RequestBody ReflexionInicial nueva) {
        ReflexionInicial actual = service.obtenerPorId(id);
        if (nueva.getIkigai() != null) actual.setIkigai(nueva.getIkigai());
        if (nueva.getEntrevistas() != null) actual.setEntrevistas(nueva.getEntrevistas());
        if (nueva.getMapaEmpatia() != null) actual.setMapaEmpatia(nueva.getMapaEmpatia());
        return service.guardar(actual);
    
    }

    @GetMapping("/proyecto/{proyectoId}")
    public List<ReflexionInicial> listarPorProyecto(@PathVariable Long proyectoId) {
        return service.listarPorProyecto(proyectoId);
    }

    @GetMapping
    public List<ReflexionInicial> listarTodo() {
        return service.listarTodo();
    }
}
