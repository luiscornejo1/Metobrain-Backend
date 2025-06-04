

package com.agileboard.service;



import com.agileboard.model.Retrospectiva;
import com.agileboard.repository.RetrospectivaRepository;

import jakarta.persistence.*;
import java.util.List;
import com.agileboard.model.Sprint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

@Service
public class RetrospectivaService {

    @Autowired
    private RetrospectivaRepository repository;

    public Retrospectiva guardar(Retrospectiva r) {
        return repository.save(r);
    }

    public List<Retrospectiva> listarPorSprint(Long sprintId) {
        return repository.findBySprintId(sprintId);
    }
}
