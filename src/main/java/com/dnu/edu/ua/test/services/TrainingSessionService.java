package com.dnu.edu.ua.test.services;

import com.dnu.edu.ua.test.entities.Member;
import com.dnu.edu.ua.test.entities.TrainingSession;
import com.dnu.edu.ua.test.repositories.MemberRepository;
import com.dnu.edu.ua.test.repositories.TrainingSessionRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TrainingSessionService {
    private final TrainingSessionRepository trainingSessionRepository;

    public List<TrainingSession> getAllSessions() {
        return trainingSessionRepository.findAll();
    }
    public TrainingSession createSession(TrainingSession trainingSession) {
        return trainingSessionRepository.save(trainingSession);
    }
    public List<TrainingSession> getSessionsByTrainer(Long trainerId) {
        return trainingSessionRepository.findByTrainerId(trainerId);
    }
}
