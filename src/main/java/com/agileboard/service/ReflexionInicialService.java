package com.agileboard.service;

import com.agileboard.model.Proyecto;
import com.agileboard.model.ReflexionInicial;
import com.agileboard.repository.ProyectoRepository;
import com.agileboard.repository.ReflexionInicialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReflexionInicialService {

    @Autowired
    private ProyectoRepository proyectoRepository;

    @Autowired
    private ReflexionInicialRepository repository;

    public ReflexionInicial guardar(ReflexionInicial reflexion) {
        Long proyectoId = reflexion.getProyecto().getId();

        Proyecto proyecto = proyectoRepository.findById(proyectoId)
            .orElseThrow(() -> new RuntimeException("Proyecto no encontrado"));

        reflexion.setProyecto(proyecto);
        return repository.save(reflexion);
    }

    public ReflexionInicial obtenerPorId(Long id) {
        return repository.findById(id).orElseThrow();
    }

    public List<ReflexionInicial> listarPorProyecto(Long proyectoId) {
        return repository.findByProyectoId(proyectoId);
    }

    public List<ReflexionInicial> listarTodo() {
        return repository.findAll();
    }
}
