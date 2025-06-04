package com.agileboard.controller;

import com.agileboard.model.Prototipo;
import com.agileboard.model.SprintBacklogItem;
import com.agileboard.model.Proyecto;
import com.agileboard.repository.PrototipoRepository;
import com.agileboard.repository.ProyectoRepository;
import com.agileboard.repository.SprintBacklogItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@RequestMapping("/api/prototipos")
@CrossOrigin(origins = "http://localhost:5173")
public class PrototipoController {

    @Autowired
    private PrototipoRepository prototipoRepo;

    @Autowired
    private ProyectoRepository proyectoRepo;

    @Autowired
    private SprintBacklogItemRepository sprintRepo;

    // ✅ Obtener todos los prototipos de un proyecto
    @GetMapping("/proyecto/{proyectoId}")
    public List<Prototipo> listarPorProyecto(@PathVariable Long proyectoId) {
        return prototipoRepo.findByProyectoId(proyectoId);
    }

    // ✅ Crear un prototipo y asociar historias
    @PostMapping
    public Prototipo crearPrototipo(@RequestBody Prototipo prototipo) {
        // Verificar que el proyecto existe
        Proyecto proyecto = proyectoRepo.findById(prototipo.getProyecto().getId())
                .orElseThrow(() -> new RuntimeException("Proyecto no encontrado"));
        prototipo.setProyecto(proyecto);

        // Asociar historias del Sprint Backlog si se envían
        if (prototipo.getHistorias() != null && !prototipo.getHistorias().isEmpty()) {
            List<Long> idsHistorias = prototipo.getHistorias().stream()
                    .map(SprintBacklogItem::getId)
                    .toList();
            List<SprintBacklogItem> historias = sprintRepo.findAllById(idsHistorias);
            prototipo.setHistorias(historias);
        }

        return prototipoRepo.save(prototipo);
    }

    // ✅ Actualizar solo el estado de validación del prototipo
    @PutMapping("/{id}")
    public ResponseEntity<Prototipo> actualizarEstadoPrototipo(
            @PathVariable Long id,
            @RequestBody Prototipo actualizado) {

        Prototipo prototipo = prototipoRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Prototipo no encontrado"));

        if (actualizado.getEstadoValidacion() != null) {
            prototipo.setEstadoValidacion(actualizado.getEstadoValidacion());
        }

        Prototipo guardado = prototipoRepo.save(prototipo);
        return ResponseEntity.ok(guardado);
    }

    // ✅ Eliminar un prototipo
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarPrototipo(@PathVariable Long id) {
        Prototipo prototipo = prototipoRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Prototipo no encontrado"));
        prototipoRepo.delete(prototipo);
        return ResponseEntity.ok().build();
    }
}
