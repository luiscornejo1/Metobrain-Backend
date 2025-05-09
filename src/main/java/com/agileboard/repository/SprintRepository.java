package com.agileboard.repository;

import com.agileboard.model.Sprint;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SprintRepository extends JpaRepository<Sprint, Long> {
    List<Sprint> findByProyectoId(Long proyectoId);
}
