package com.agileboard.controller;

import com.agileboard.model.CierreProyecto;
import com.agileboard.model.Proyecto;
import com.agileboard.repository.CierreProyectoRepository;
import com.agileboard.repository.ProyectoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/cierre")
@CrossOrigin(origins = "http://localhost:5173")
public class CierreProyectoController {
    @Autowired
    private CierreProyectoRepository cierreProyectoRepository;

    @Autowired
    private ProyectoRepository proyectoRepository;

    @PostMapping("/{proyectoId}")
    public CierreProyecto crearCierreProyecto(@PathVariable Long proyectoId, @RequestBody CierreProyecto cierreProyecto) {
        Proyecto proyecto = proyectoRepository.findById(proyectoId)
                .orElseThrow(() -> new RuntimeException("Proyecto no encontrado con ID: " + proyectoId));
        cierreProyecto.setProyecto(proyecto);
        return cierreProyectoRepository.save(cierreProyecto);
    }

    @GetMapping("/{proyectoId}")
    public List<CierreProyecto> obtenerCierresPorProyecto(@PathVariable Long proyectoId) {
        return cierreProyectoRepository.findByProyectoId(proyectoId);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        cierreProyectoRepository.deleteById(id);
    }
}
    