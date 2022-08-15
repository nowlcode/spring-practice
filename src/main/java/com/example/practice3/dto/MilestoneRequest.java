package com.example.practice3.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MilestoneRequest {
    private String title;
    private String status;
    private Long authorId;
    private Long personInChargeId;
    private String createdAt;
    private String completedBy;
    private String body;

    public MilestoneRequest(String title, String status, Long authorId, Long personInChargeId,
                            String createdAt, String completedBy, String body){
        this.title = title;
        this.status = status;
        this.authorId = authorId;
        this.personInChargeId = personInChargeId;
        this.createdAt = createdAt;
        this.completedBy = completedBy;
        this.body = body;

    }

//    @Builder
//    public Milestone toEntity(MilestoneRequest milestoneRequest){
//        return Milestone.builder()
//                .title(milestoneRequest.getTitle())
//                .status(MilestoneStatus.valueOf(milestoneRequest.getStatus()))
//                .author(milestoneRequest.getAuthorId())
//                .personInCharge()
//                .createdAt()
//                .completedBy()
//                .body()
//                .build();
//    }
}
