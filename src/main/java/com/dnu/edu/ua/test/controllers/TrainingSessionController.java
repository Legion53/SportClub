package com.dnu.edu.ua.test.controllers;

import com.dnu.edu.ua.test.entities.Member;
import com.dnu.edu.ua.test.entities.TrainingSession;
import com.dnu.edu.ua.test.services.MemberService;
import com.dnu.edu.ua.test.services.TrainingSessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sessions")
public class TrainingSessionController {

    @Autowired
    private TrainingSessionService trainingSessionService;

    @Autowired
    private MemberService memberService;

    @GetMapping
    public List<TrainingSession> getAllSessions() {
        return trainingSessionService.getAllSessions();
    }

    @PostMapping
    public TrainingSession createSession(@RequestBody TrainingSession session) {
        Member member = memberService.getMemberById(session.getMember().getId())
                .orElseThrow(() -> new RuntimeException("Member not found for session"));

        session.setMember(member);

        return trainingSessionService.createSession(session);
    }

    @GetMapping("/by-trainer/{trainerId}")
    public List<TrainingSession> getSessionsByTrainer(@PathVariable Long trainerId) {
        return trainingSessionService.getSessionsByTrainer(trainerId);
    }
}
