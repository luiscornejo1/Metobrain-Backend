package com.agileboard.service;

import com.agileboard.model.Proyecto;
import com.agileboard.repository.ProyectoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;


import java.util.List;
import java.util.Optional;

@Service
public class ProyectoService {

    @Autowired
    private ProyectoRepository proyectoRepository;

    public List<Proyecto> getTodosLosProyectos() {
        return proyectoRepository.findAll();
    }


    public List<Proyecto> getProyectosPorUsuario(Long usuarioId) {
        return proyectoRepository.findByOwnerId(usuarioId);
    }

    public Optional<Proyecto> getProyectoById(Long id) {
        return proyectoRepository.findById(id);
    }

    public Proyecto crearProyecto(Proyecto proyecto) {
        return proyectoRepository.save(proyecto);
    }

    public void eliminarProyecto(Long id) {
        proyectoRepository.deleteById(id);
    }
}
