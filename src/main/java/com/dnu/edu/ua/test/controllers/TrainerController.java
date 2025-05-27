package com.dnu.edu.ua.test.controllers;

import com.dnu.edu.ua.test.entities.Trainer;
import com.dnu.edu.ua.test.services.TrainerService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trainers")
public class TrainerController {
    @Autowired
    private TrainerService trainerService;

    @GetMapping
    public List<Trainer> getAllTrainers() {
        return trainerService.getAllTrainers();
    }
    @PostMapping
    public Trainer createTrainer(@RequestBody Trainer trainer) {
        return trainerService.createTrainer(trainer);
    }
    @GetMapping("/{id}")
    public Trainer getTrainerById(@PathVariable Long id) {
        return trainerService.getTrainerById(id)
                .orElseThrow(() -> new RuntimeException("Trainer isn`t found"));
    }
}
