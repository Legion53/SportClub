package com.dnu.edu.ua.test.services;

import com.dnu.edu.ua.test.entities.Member;
import com.dnu.edu.ua.test.repositories.MemberRepository;
import com.dnu.edu.ua.test.repositories.TrainerRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }
    public Member createMember(Member member) {
        return memberRepository.save(member);
    }
    public Optional<Member> getMemberById(Long id) {
        return memberRepository.findById(id);
    }
}
