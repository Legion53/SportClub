package com.dnu.edu.ua.test.controllers;

import com.dnu.edu.ua.test.entities.Member;
import com.dnu.edu.ua.test.entities.Trainer;
import com.dnu.edu.ua.test.services.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/members")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @GetMapping
    public List<Member> getAllMembers() {
        return memberService.getAllMembers();
    }
    @PostMapping
    public Member createMember(@RequestBody Member member) {
        return memberService.createMember(member);
    }
    @GetMapping("/{id}")
    public Member getMemberById(@PathVariable Long id) {
        return memberService.getMemberById(id)
                .orElseThrow(() -> new RuntimeException("Member isn`t found"));
    }
}
