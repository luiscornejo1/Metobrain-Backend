package com.agileboard.repository;

import com.agileboard.model.Proyecto;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface ProyectoRepository extends JpaRepository<Proyecto, Long> {
    List<Proyecto> findByOwnerId(Long ownerId);
}
