package com.agileboard.repository;

import com.agileboard.model.Tarea;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TareaRepository extends JpaRepository<Tarea, Long> {
    List<Tarea> findBySprintId(Long sprintId);
}
