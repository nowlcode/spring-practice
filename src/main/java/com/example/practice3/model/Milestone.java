package com.example.practice3.model;

import com.example.practice3.dto.MilestoneRequest;
import com.example.practice3.dto.MilestoneResponse;
import com.example.practice3.enums.MilestoneStatus;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static java.time.temporal.ChronoUnit.DAYS;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Milestone {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long milestoneId;

    @Column(name= "TITLE", nullable = false)
    private String title;

    @Column(name = "STATUS")
    private MilestoneStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "AUTHOR")
    private Member author;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PERSON_IN_CHARGE")
    private Member personInCharge;

    @Column(name= "CREATED_AT")
    private LocalDate createdAt;

    @Column(name= "COMPLETED_BY")
    private LocalDate completedBy;

    @Column(name = "BODY", nullable = false)
    private String body;

    public Milestone(String title, MilestoneStatus status, Member author, Member personInCharge,
                     LocalDate createdAt, LocalDate completedBy, String body){
        this.title = title;
        this.status = status;
        this.author = author;
        this.personInCharge = personInCharge;
        this.createdAt = createdAt;
        this.completedBy = completedBy;
        this.body = body;
    }

    public MilestoneResponse toResponse(Milestone milestone){
        return MilestoneResponse.builder()
                .title(milestone.getTitle())
                .status(milestone.getStatus().toString())
                .authorId(milestone.getAuthor().getMemberId())
                .personInChargeId(milestone.getPersonInCharge().getMemberId())
                .dueDay(DAYS.between(milestone.getCreatedAt(),LocalDate.now()))
                .body(milestone.getBody())
                .build();
    }

    public void update(MilestoneRequest milestoneRequest, Member personInCharge) {
        this.title = milestoneRequest.getTitle();
        this.status = MilestoneStatus.valueOf(milestoneRequest.getStatus());
        this.personInCharge = personInCharge;
        this.createdAt = LocalDate.parse(milestoneRequest.getCreatedAt(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        this.completedBy = LocalDate.parse(milestoneRequest.getCompletedBy(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        this.body = milestoneRequest.getBody();
    }
}
