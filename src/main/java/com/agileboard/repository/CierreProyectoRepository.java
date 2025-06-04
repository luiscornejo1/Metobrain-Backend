package com.agileboard.repository;

import com.agileboard.model.CierreProyecto;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


public interface CierreProyectoRepository extends JpaRepository<CierreProyecto, Long> {
List<CierreProyecto> findByProyectoId(Long proyectoId);
}