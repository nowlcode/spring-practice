package com.example.practice3.controller;

import com.example.practice3.dto.MilestoneRequest;
import com.example.practice3.dto.MilestoneResponse;
import com.example.practice3.service.MilestoneService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/milestone")
@RequiredArgsConstructor
public class MilestoneController {
    private final MilestoneService milestoneService;

    @PostMapping
    public void createMilestone(@RequestBody MilestoneRequest milestoneRequest){
        milestoneService.createMilestone(milestoneRequest);
    }

    @GetMapping
    public List<MilestoneResponse> getAllMilestones(){
        return milestoneService.getAllMilestones();
    }

    @GetMapping("/{milestoneId}")
    public MilestoneResponse getMilestoneById(@PathVariable Long milestoneId){
        return milestoneService.getMilestoneById(milestoneId);
    }

    @PutMapping("/{milestoneId}")
    public void updateMilestone(@PathVariable Long milestoneId, @RequestBody MilestoneRequest milestoneRequest){
        return milestoneService.updateMilestone(milestoneId, milestoneRequest);
    }

}
