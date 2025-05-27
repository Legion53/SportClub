package com.dnu.edu.ua.test.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "training_sessions")
public class TrainingSession {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "trainer_id", nullable = false)
    private Trainer trainer;
    @ManyToOne
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;
    @Column(name = "date_time")
    private LocalDateTime dateTime;
    @Column(name = "duration")
    private int duration;

    public TrainingSession() {

    }
    public TrainingSession(Trainer trainer, Member member, LocalDateTime dateTime, int duration) {
        this.trainer = trainer;
        this.member = member;
        this.dateTime = dateTime;
        this.duration = duration;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Trainer getTrainer() {
        return trainer;
    }

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public LocalDateTime getDateTimes() {
        return dateTime;
    }

    public void setDateTimes(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
