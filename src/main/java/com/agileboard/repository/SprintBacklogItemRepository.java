package com.agileboard.repository;

import com.agileboard.model.SprintBacklogItem;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface SprintBacklogItemRepository extends JpaRepository<SprintBacklogItem, Long> {
    List<SprintBacklogItem> findByProyectoId(Long proyectoId);
}
