package com.example.practice3.service;

import com.example.practice3.dto.MilestoneRequest;
import com.example.practice3.model.Milestone;
import com.example.practice3.model.MilestoneStatus;
import com.example.practice3.repository.MemberRepository;
import com.example.practice3.repository.MilestoneRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
@RequiredArgsConstructor
public class MilestoneService {
    private final MilestoneRepository milestoneRepository;
    private final MemberRepository memberRepository;


    
    public Milestone toEntity(MilestoneRequest milestoneRequest){
        return Milestone.builder()
                .title(milestoneRequest.getTitle())
                .status(MilestoneStatus.valueOf(milestoneRequest.getStatus()))
                .author(memberRepository.findById(milestoneRequest.getAuthorId()).orElseThrow(
                        ()-> new NullPointerException("Cannot find Author!")
                ))
                .personInCharge(memberRepository.findById(milestoneRequest.getPersonInChargeId()).orElseThrow(
                        ()-> new NullPointerException("Cannot find Person-In-Charge!")
                ))
                .createdAt(LocalDateTime.parse(milestoneRequest.getCreatedAt(),DateTimeFormatter.ofPattern("yyyy-MM-dd")))
                .completedBy(LocalDateTime.parse(milestoneRequest.getCompletedBy(),DateTimeFormatter.ofPattern("yyyy-MM-dd")))
                .body(milestoneRequest.getBody())
                .build();
    }
}
