package com.example.practice3.dto;

import com.example.practice3.model.Milestone;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

import static java.time.temporal.ChronoUnit.DAYS;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MilestoneResponse {
    private String title;
    private String status;
    private Long authorId;
    private Long personInChargeId;
    private Long dueDay;
    private String body;

    public MilestoneResponse(String title, String status, Long authorId, Long personInChargeId,
                             Long dueDay, String body){
        this.title = title;
        this.status = status;
        this.authorId = authorId;
        this.personInChargeId = personInChargeId;
        this.dueDay = dueDay;
        this.body = body;

    }

    public void toResponse(Milestone milestone){
        this.title = milestone.getTitle();
        this.status = milestone.getStatus().toString();
        this.authorId = milestone.getAuthor().getMemberId();
        this.personInChargeId = milestone.getPersonInCharge().getMemberId();
        this.dueDay = DAYS.between(milestone.getCreatedAt(), LocalDateTime.now());
        this.body = milestone.getBody();
    }
}
