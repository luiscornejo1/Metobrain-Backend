package com.agileboard.controller;

import com.agileboard.model.Entrevista;
import com.agileboard.model.Proyecto;
import com.agileboard.repository.EntrevistaRepository;
import com.agileboard.repository.ProyectoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/entrevistas")
@CrossOrigin(origins = "http://localhost:5173")
public class EntrevistaController {

    @Autowired
    private EntrevistaRepository entrevistaRepository;

    @Autowired
    private ProyectoRepository proyectoRepository;

    @PostMapping
    public Entrevista guardar(@RequestBody Entrevista entrevista) {
        Long proyectoId = entrevista.getProyecto().getId();
        Proyecto proyecto = proyectoRepository.findById(proyectoId)
                .orElseThrow(() -> new RuntimeException("Proyecto no encontrado"));
        entrevista.setProyecto(proyecto);
        return entrevistaRepository.save(entrevista);
    }

    @GetMapping("/proyecto/{proyectoId}")
    public List<Entrevista> listarPorProyecto(@PathVariable Long proyectoId) {
        return entrevistaRepository.findByProyectoId(proyectoId);
    }
}
