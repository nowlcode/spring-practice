package com.example.practice3.service;

import com.example.practice3.dto.MilestoneRequest;
import com.example.practice3.dto.MilestoneResponse;
import com.example.practice3.model.Member;
import com.example.practice3.model.Milestone;
import com.example.practice3.enums.MilestoneStatus;
import com.example.practice3.repository.MemberRepository;
import com.example.practice3.repository.MilestoneRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MilestoneService {
    private final MilestoneRepository milestoneRepository;
    private final MemberRepository memberRepository;

    //PostMapping
    public void createMilestone(MilestoneRequest milestoneRequest){
        Milestone milestone = this.toEntity(milestoneRequest);
        milestoneRepository.save(milestone);
    }

    //GetMapping (All)
    public List<MilestoneResponse> getAllMilestones() {
        List<Milestone> milestones = milestoneRepository.findAll();
        List<MilestoneResponse> milestoneResponses = new ArrayList<>();
        for (int i = 0; i<milestones.size(); i++){
            milestoneResponses.add(milestones.get(i).toResponse(milestones.get(i)));
        }
        return milestoneResponses;
    }

    //GetMapping (byId)
    public MilestoneResponse getMilestoneById(Long milestoneId) {
        Milestone milestone = milestoneRepository.findById(milestoneId).orElseThrow(
                () -> new NullPointerException("Milestone not found!")
        );
        return milestone.toResponse(milestone);
    }

    //PutMapping
    public void updateMilestone(Long milestoneId, MilestoneRequest milestoneRequest) {
        Milestone milestone = milestoneRepository.findById(milestoneId).orElseThrow(
                () -> new NullPointerException("Milestone not found!")
        );
        Member personInCharge = memberRepository.findById(milestoneRequest.getPersonInChargeId()).orElseThrow(
                ()-> new NullPointerException("Member not found!")
        );
        milestone.update(milestoneRequest, personInCharge);
        milestoneRepository.save(milestone);
    }

    //DeleteMapping
    public Long deleteMilestone(Long milestoneId) {
        milestoneRepository.deleteById(milestoneId);
        return milestoneId;
    }


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
                .createdAt(LocalDate.parse(milestoneRequest.getCreatedAt(),DateTimeFormatter.ofPattern("yyyy-MM-dd")))
                .completedBy(LocalDate.parse(milestoneRequest.getCompletedBy(),DateTimeFormatter.ofPattern("yyyy-MM-dd")))
                .body(milestoneRequest.getBody())
                .build();
    }
}
