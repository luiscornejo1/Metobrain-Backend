package com.agileboard.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import java.util.List;

@RestController
@RequestMapping("/api/ideas")
@CrossOrigin(origins = "http://localhost:5173") // Ajusta si es necesario
public class IdeasController {

    // 🟣 Ejemplo: Recibe el product backlog en el body y devuelve "OK"
    @PostMapping("/generar")
    public ResponseEntity<?> generarIdeas(@RequestBody List<String> productBacklog) {
        // Aquí normalmente llamarías a OpenAI o generas ideas
        // Ejemplo básico:
        System.out.println("Ideas generadas para el Product Backlog: " + productBacklog);
        return ResponseEntity.ok("¡Ideas generadas exitosamente!");
    }
}
