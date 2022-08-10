package com.example.practice3.dto;

import com.example.practice3.model.Milestone;
import com.example.practice3.model.MilestoneStatus;
import lombok.Builder;
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

}
