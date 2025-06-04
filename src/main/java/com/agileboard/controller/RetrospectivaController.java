
package com.agileboard.model;

import com.agileboard.model.Retrospectiva;
import com.agileboard.service.RetrospectivaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/retrospectivas")
public class RetrospectivaController {

    @Autowired
    private RetrospectivaService service;

    @PostMapping
    public ResponseEntity<Retrospectiva> guardar(@RequestBody Retrospectiva r) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.guardar(r));
    }

    @GetMapping("/sprint/{sprintId}")
    public List<Retrospectiva> listarPorSprint(@PathVariable Long sprintId) {
        return service.listarPorSprint(sprintId);
    }
}
