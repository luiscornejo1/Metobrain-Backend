package com.agileboard.repository;

import com.agileboard.model.Prototipo;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PrototipoRepository extends JpaRepository<Prototipo, Long> {
    List<Prototipo> findByProyectoId(Long proyectoId);
}
