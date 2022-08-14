package com.example.practice3.controller;

import com.example.practice3.dto.MemberDto;
import com.example.practice3.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/member")
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @PostMapping
    public void createMember(@RequestBody MemberDto memberDto){
        memberService.createMember(memberDto);
    }

    @GetMapping("/{memberId}")
    public MemberDto getMember(@PathVariable Long memberId){
        return memberService.getMember(memberId);
    }

    @PutMapping("/{memberId}")
    public void updateMember(@PathVariable Long memberId, @RequestBody MemberDto memberDto){
        memberService.updateMember(memberId, memberDto);
    }

    @DeleteMapping("/{memberId}")
    public Long deleteMember(@PathVariable Long memberId){
        return memberService.deleteMember(memberId);
    }

}
