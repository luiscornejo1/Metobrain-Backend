package com.agileboard.service;

import com.agileboard.model.Sprint;
import com.agileboard.repository.SprintRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;



import java.util.List;
import java.util.stream.Collectors;
import com.agileboard.dto.SprintDTO;

@Service
public class SprintService {

    @Autowired
    private SprintRepository sprintRepository;

    public List<Sprint> listarTodos() {
        return sprintRepository.findAll();
        
    }

    public List<SprintDTO> listarSprintsDTO() {
         return sprintRepository.findAll().stream().map(s ->
         new SprintDTO(
                s.getId(),
                s.getNombre(),
                s.getFechaInicio().toString(),
                s.getFechaFin().toString(),
                s.getProyecto().getId(),
                s.getProyecto().getNombre()
                )
            ).collect(Collectors.toList());
    }
                

    


    public List<Sprint> getSprintsPorProyecto(Long proyectoId) {
        return sprintRepository.findByProyectoId(proyectoId);
    }

    public Sprint crearSprint(Sprint sprint) {
        return sprintRepository.save(sprint);
    }

    public void eliminarSprint(Long id) {
        sprintRepository.deleteById(id);
    }
    

}
