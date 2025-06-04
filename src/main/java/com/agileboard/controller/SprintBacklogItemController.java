package com.agileboard.controller;

import com.agileboard.model.BacklogItem;
import com.agileboard.model.Proyecto;
import com.agileboard.model.SprintBacklogItem;
import com.agileboard.repository.BacklogItemRepository;
import com.agileboard.repository.ProyectoRepository;
import com.agileboard.repository.SprintBacklogItemRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/sprint-backlog")
@CrossOrigin(origins = "http://localhost:5173")
public class SprintBacklogItemController {

    @Autowired
    private SprintBacklogItemRepository sprintBacklogItemRepository;

    @Autowired
    private BacklogItemRepository backlogItemRepository;

    @Autowired
    private ProyectoRepository proyectoRepository;

    // ✅ Listar Sprint Backlog por proyecto
    @GetMapping("/proyecto/{proyectoId}")
    public List<SprintBacklogItem> listarPorProyecto(@PathVariable Long proyectoId) {
        return sprintBacklogItemRepository.findByProyectoId(proyectoId);
    }

    // ✅ Crear un Sprint Backlog Item manualmente
    @PostMapping
    public SprintBacklogItem crear(@RequestBody SprintBacklogItem item) {
        Long proyectoId = item.getProyecto().getId();
        Proyecto proyecto = proyectoRepository.findById(proyectoId)
                .orElseThrow(() -> new RuntimeException("Proyecto no encontrado"));
        item.setProyecto(proyecto);

        // Vincular con la historia de usuario si viene el ID
        if (item.getProductBacklogItem() != null && item.getProductBacklogItem().getId() != null) {
            BacklogItem hu = backlogItemRepository.findById(item.getProductBacklogItem().getId())
                    .orElseThrow(() -> new RuntimeException("Historia de usuario no encontrada"));
            item.setProductBacklogItem(hu);
        }

        return sprintBacklogItemRepository.save(item);
    }

    // ✅ Actualizar Sprint Backlog
    @PutMapping("/{id}")
    public SprintBacklogItem actualizar(@PathVariable Long id, @RequestBody SprintBacklogItem actualizado) {
        SprintBacklogItem item = sprintBacklogItemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Item no encontrado"));

        if (actualizado.getDescripcion() != null) item.setDescripcion(actualizado.getDescripcion());
        if (actualizado.getPrioridadMoscow() != null) item.setPrioridadMoscow(actualizado.getPrioridadMoscow());
        if (actualizado.getEstado() != null) item.setEstado(actualizado.getEstado());

        // Actualizar vínculo con historia de usuario (opcional)
        if (actualizado.getProductBacklogItem() != null && actualizado.getProductBacklogItem().getId() != null) {
            BacklogItem hu = backlogItemRepository.findById(actualizado.getProductBacklogItem().getId())
                    .orElseThrow(() -> new RuntimeException("Historia de usuario no encontrada"));
            item.setProductBacklogItem(hu);
        }

        return sprintBacklogItemRepository.save(item);
    }

    // ✅ Eliminar un Sprint Backlog
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        sprintBacklogItemRepository.deleteById(id);
    }

    // ✅ Generar ideas con IA en base al Product Backlog
    @PostMapping("/generar-ideas")
    public List<String> generarIdeas(@RequestBody Long proyectoId) {
        // Obtener el Product Backlog del proyecto
        List<BacklogItem> productBacklog = backlogItemRepository.findByProyectoId(proyectoId);

        // Simulación: generar ideas basadas en el Product Backlog (en vez de OpenAI real)
        List<String> ideasGeneradas = productBacklog.stream()
                .map(hu -> "Basado en: " + hu.getDescripcion() + " => Idea: Nueva funcionalidad para complementar.")
                .collect(Collectors.toList());

        // Podrías reemplazarlo con una llamada a la API de OpenAI si tienes clave y endpoint listos.

        return ideasGeneradas;
    }
}
