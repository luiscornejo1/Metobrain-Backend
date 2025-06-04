package com.agileboard.repository;

import com.agileboard.model.ReflexionInicial;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReflexionInicialRepository extends JpaRepository<ReflexionInicial, Long> {
    List<ReflexionInicial> findByProyectoId(Long proyectoId);
}
