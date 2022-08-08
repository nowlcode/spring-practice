package com.example.practice3.dto;

import com.example.practice3.model.Milestone;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MilestoneResponse {
    private String title;
    private String status;
    private Long authorId;
    private Long personInChargeId;
    private String dueDay;
    private String body;

    public MilestoneResponse toResponse(Milestone milestone){
        this.title = milestone.getTitle();
        this.status = milestone.getStatus().toString();
        this.authorId = milestone.getAuthor().getMemberId();
        this.personInChargeId = milestone.getPersonInCharge().getMemberId();
    }
}
