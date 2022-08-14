package com.example.practice3.controller;

import com.example.practice3.dto.MemberDto;
import com.example.practice3.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/member")
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @PostMapping
    public void createMember(@RequestBody MemberDto memberDto){
        memberService.createMember(memberDto);
    }

}
