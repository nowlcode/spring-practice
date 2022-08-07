package com.example.practice3.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
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
    private LocalDateTime createdAt;

    @Column(name= "COMPLETED_BY")
    private LocalDateTime completedBy;

    @Column(name = "BODY", nullable = false)
    private String body;
}
