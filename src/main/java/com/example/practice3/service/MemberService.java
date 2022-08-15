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
        memberRepository.save(member);
    }

    //GetMapping
    public MemberDto getMember(Long memberId){
        Member member = memberRepository.findById(memberId).orElseThrow(
                ()->new NullPointerException("Member not found!")
        );
        return member.toMemberDto(member);
    }

    //PutMapping
    public void updateMember(Long memberId, MemberDto memberDto){
        Member member = memberRepository.findById(memberId).orElseThrow(
                ()-> new NullPointerException("Member not found!")
        );
        member.update(memberDto);
        memberRepository.save(member);
    }

    //DeleteMapping
    public Long deleteMember(Long memberId){
        memberRepository.deleteById(memberId);
        return memberId;
    }
}
