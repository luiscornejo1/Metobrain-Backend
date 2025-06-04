package com.agileboard.repository;

import com.agileboard.model.BacklogItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BacklogItemRepository extends JpaRepository<BacklogItem, Long> {
    List<BacklogItem> findByProyectoId(Long proyectoId);
}
