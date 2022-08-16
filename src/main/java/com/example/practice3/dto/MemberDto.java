package com.example.practice3.dto;

import com.example.practice3.model.Member;
import com.example.practice3.enums.MemberRole;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class MemberDto {
    private String name;
    private String picUrl;
    private String role;

    public MemberDto(String name, String picUrl, String role){
        this.name = name;
        this.picUrl = picUrl;
        this.role = role;
    }

    public Member toMember(MemberDto memberDto) {
        return Member.builder()
                .name(memberDto.getName())
                .picUrl(memberDto.getPicUrl())
                .role(MemberRole.valueOf(memberDto.getRole()))
                .build();
    }
}
