package com.dnu.edu.ua.test.repositories;

import com.dnu.edu.ua.test.entities.TrainingSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrainingSessionRepository extends JpaRepository<TrainingSession, Long> {
    List<TrainingSession> findByTrainerId(Long trainerId);
}
