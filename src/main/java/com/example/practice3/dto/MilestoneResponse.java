package com.example.practice3.dto;

import com.example.practice3.model.Milestone;
import lombok.*;

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

    @Builder
    public MilestoneResponse(String title, String status, Long authorId, Long personInChargeId,
                             Long dueDay, String body){
        this.title = title;
        this.status = status;
        this.authorId = authorId;
        this.personInChargeId = personInChargeId;
        this.dueDay = dueDay;
        this.body = body;

    }

}
