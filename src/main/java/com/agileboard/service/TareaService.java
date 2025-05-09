package com.agileboard.service;

import com.agileboard.dto.SprintCycleTimeDTO;
import com.agileboard.dto.AvanceSprintDTO;
import com.agileboard.dto.ConteoEstadoDTO;
import com.agileboard.model.EstadoTarea;
import com.agileboard.model.Sprint;
import com.agileboard.model.Tarea;
import com.agileboard.repository.SprintRepository;
import com.agileboard.repository.TareaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.agileboard.dto.ConteoEstadoDTO;
import java.util.Map;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@Service
public class TareaService {

    @Autowired
    private TareaRepository tareaRepository;

    @Autowired
    private SprintRepository sprintRepository;

    // Crear tarea
    public Tarea crearTarea(Tarea tarea) {
        return tareaRepository.save(tarea);
    }

    // Actualizar tarea y calcular cycleTime si está COMPLETADA
    public Tarea actualizarTarea(Long id, Tarea tareaActualizada) {
        return tareaRepository.findById(id).map(tarea -> {
            tarea.setTitulo(tareaActualizada.getTitulo());
            tarea.setDescripcion(tareaActualizada.getDescripcion());
            tarea.setEstado(tareaActualizada.getEstado());
            tarea.setSprint(tareaActualizada.getSprint());

            if (tarea.getEstado() == EstadoTarea.COMPLETADA) {
                long tiempoFinal = System.currentTimeMillis();
                long tiempoEnMilisegundos = tiempoFinal - tarea.getStartTime();
                long horas = tiempoEnMilisegundos / (1000 * 60 * 60);
                tarea.setCycleTime(horas);
            }

            return tareaRepository.save(tarea);
        }).orElseThrow(() -> new RuntimeException("Tarea no encontrada"));
    }

    // Eliminar tarea
    public void eliminarTarea(Long id) {
        tareaRepository.deleteById(id);
    }

    // Obtener todas las tareas
    public List<Tarea> listarTodas() {
        return tareaRepository.findAll();
    }

    // Obtener tareas por Sprint
    public List<Tarea> getTareasPorSprint(Long sprintId) {
        return tareaRepository.findBySprintId(sprintId);
    }

    // Dashboard: Promedio de cycleTime por Sprint
    public List<SprintCycleTimeDTO> obtenerPromedioCycleTimePorSprint() {
        List<SprintCycleTimeDTO> resultado = new ArrayList<>();

        List<Sprint> sprints = sprintRepository.findAll();
        for (Sprint sprint : sprints) {
            List<Tarea> tareas = tareaRepository.findBySprintId(sprint.getId());

            double promedio = tareas.stream()
                .filter(t -> t.getEstado() == EstadoTarea.COMPLETADA && t.getCycleTime() != null)
                .mapToLong(Tarea::getCycleTime)
                .average()
                .orElse(0);

            resultado.add(new SprintCycleTimeDTO(sprint.getId(), sprint.getNombre(), promedio));
        }

        return resultado;
    }

    public List<ConteoEstadoDTO> contarTareasPorEstadoGlobal() {
    List<Tarea> tareas = tareaRepository.findAll();
    return tareas.stream()
        .collect(Collectors.groupingBy(
            t -> t.getEstado().name(),
            Collectors.counting()
        ))
        .entrySet().stream()
        .map(e -> new ConteoEstadoDTO(e.getKey(), e.getValue()))
        .collect(Collectors.toList());
}

    public List<ConteoEstadoDTO> contarTareasPorEstadoPorSprint(Long sprintId) {
        List<Tarea> tareas = tareaRepository.findBySprintId(sprintId);
        return tareas.stream()
            .collect(Collectors.groupingBy(
                t -> t.getEstado().name(),
                Collectors.counting()
            ))
            .entrySet().stream()
            .map(e -> new ConteoEstadoDTO(e.getKey(), e.getValue()))
            .collect(Collectors.toList());
            
            }


    public List<AvanceSprintDTO> obtenerAvancePorSprint() {
         List<AvanceSprintDTO> resultado = new ArrayList<>();

         List<Sprint> sprints = sprintRepository.findAll();
         
         for (Sprint sprint : sprints) {
            List<Tarea> tareas = tareaRepository.findBySprintId(sprint.getId());
            int total = tareas.size();
            int completadas = (int) tareas.stream()
            .filter(t -> t.getEstado() == EstadoTarea.COMPLETADA)
            .count();

             double avance = total == 0 ? 0.0 : ((double) completadas / total) * 100;

             resultado.add(new AvanceSprintDTO(
                    sprint.getId(),
                    sprint.getNombre(),
                    total,
                    completadas,
                    Math.round(avance * 100.0) / 100.0
                ));
                
            }

            return resultado;
    }
}
