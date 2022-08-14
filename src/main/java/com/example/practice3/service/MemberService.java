package com.example.practice3.service;

import com.example.practice3.dto.MemberDto;
import com.example.practice3.model.Member;
import com.example.practice3.model.Milestone;
import com.example.practice3.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    //PostMapping
    public void createMember(MemberDto memberDto) {
        Member member = memberDto.toMember(memberDto);
        memberRepository.save();
    }

    //GetMapping

    //PutMapping

    //DeleteMapping
}
