package com.example.practice3.controller;

import com.example.practice3.dto.MemberDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/member")
public class MemberController {
    @PostMapping
    public void createMember(@RequestBody MemberDto memberDto){

    }

}
