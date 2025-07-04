package com.dnu.edu.ua.test.services;

import com.dnu.edu.ua.test.entities.Trainer;
import com.dnu.edu.ua.test.repositories.TrainerRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TrainerService {
    private final TrainerRepository trainerRepository;

    public List<Trainer> getAllTrainers() {
        return trainerRepository.findAll();
    }
    public Trainer createTrainer(Trainer trainer) {
        return trainerRepository.save(trainer);
    }
    public Optional<Trainer> getTrainerById(Long id) {
        return trainerRepository.findById(id);
    }
}
