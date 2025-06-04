package com.agileboard.repository;

import com.agileboard.model.Entrevista;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface EntrevistaRepository extends JpaRepository<Entrevista, Long> {
    List<Entrevista> findByProyectoId(Long proyectoId);
}
