package com.example.practice3.dto;

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
}
