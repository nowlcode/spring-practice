package com.example.practice3.dto;

import com.example.practice3.model.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberDto {
    private String name;
    private String picUrl;
    private String role;

    @Builder
    public MemberDto(String name, String picUrl, String role){
        this.name = name;
        this.picUrl = picUrl;
        this.role = role;
    }

    public Member toMember(MemberDto memberDto) {
        return Member.builder()
                .build();
    }
}
