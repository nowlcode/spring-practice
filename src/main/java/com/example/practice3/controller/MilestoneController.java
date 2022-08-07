package com.example.practice3.controller;

import com.example.practice3.dto.MilestoneRequest;
import com.example.practice3.service.MilestoneService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/milestone")
@RequiredArgsConstructor
public class MilestoneController {
    private final MilestoneService milestoneService;

    @PostMapping
    public void createMilestone(@RequestBody MilestoneRequest milestoneRequest){

    }

}
