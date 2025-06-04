package com.agileboard.controller;

import com.agileboard.model.BacklogItem;
import com.agileboard.model.Proyecto;
import com.agileboard.repository.BacklogItemRepository;
import com.agileboard.repository.ProyectoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.util.List;


@RestController
@RequestMapping("/api/backlog")
@CrossOrigin(origins = "http://localhost:5173")
public class BacklogItemController {

    @Autowired
    private BacklogItemRepository backlogItemRepository;

    @Autowired
    private ProyectoRepository proyectoRepository;

    @PostMapping
    public BacklogItem crearItem(@RequestBody BacklogItem item) {
        // Validar proyecto
        Long proyectoId = item.getProyecto().getId();
        Proyecto proyecto = proyectoRepository.findById(proyectoId)
                .orElseThrow(() -> new RuntimeException("Proyecto no encontrado"));
        item.setProyecto(proyecto);

        // Asignar prioridad por defecto si no se define
        if (item.getPrioridad() == null || item.getPrioridad().isEmpty()) {
            item.setPrioridad("Media");
        }

        // Asignar épica por defecto si no se define
        if (item.getEpica() == null || item.getEpica().isEmpty()) {
            item.setEpica("General");
        }

        // Guardar fecha de creación
        item.setCreatedAt(LocalDateTime.now());

        return backlogItemRepository.save(item);
    }

    @GetMapping("/proyecto/{proyectoId}")
    public List<BacklogItem> listarPorProyecto(@PathVariable Long proyectoId) {
        return backlogItemRepository.findByProyectoId(proyectoId);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarItem(@PathVariable Long id) {
        backlogItemRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<BacklogItem> actualizarBacklogItem(
            @PathVariable Long id,
            @RequestBody BacklogItem updatedItem) {
        BacklogItem item = backlogItemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Backlog item no encontrado"));

        // Actualizar prioridad
        if (updatedItem.getPrioridad() != null) {
            item.setPrioridad(updatedItem.getPrioridad());
        }

        // Actualizar story points
        if (updatedItem.getStoryPoints() != null) {
            item.setStoryPoints(updatedItem.getStoryPoints());
        }

        // Actualizar responsable como texto
        if (updatedItem.getResponsable() != null && !updatedItem.getResponsable().isEmpty()) {
            item.setResponsable(updatedItem.getResponsable());
        }

        // Actualizar estado y fechas relevantes
        if (updatedItem.getEstado() != null) {
            item.setEstado(updatedItem.getEstado());

            // Si pasa a En progreso, registrar startedAt si aún no tiene valor
            if (updatedItem.getEstado().equals("En progreso") && item.getStartedAt() == null) {
                item.setStartedAt(LocalDateTime.now());
            }

            // Si pasa a Hecho, registrar completedAt si aún no tiene valor
            if (updatedItem.getEstado().equals("Hecho") && item.getCompletedAt() == null) {
                item.setCompletedAt(LocalDateTime.now());
            }
        }

        // Actualizar épica o tema
        if (updatedItem.getEpica() != null && !updatedItem.getEpica().isEmpty()) {
            item.setEpica(updatedItem.getEpica());
        }

        backlogItemRepository.save(item);
        return ResponseEntity.ok(item);
    }

    // ✅ Endpoint para enviar fechas (opcional para graficar)
    @GetMapping("/proyecto/{proyectoId}/fechas")
    public List<BacklogItem> getFechasPorProyecto(@PathVariable Long proyectoId) {
        return backlogItemRepository.findByProyectoId(proyectoId);
    }
}
