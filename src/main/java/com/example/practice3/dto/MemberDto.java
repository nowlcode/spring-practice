package com.example.practice3.dto;

import com.example.practice3.model.Member;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberDto {
    private String name;
    private String picUrl;
    private String role;

    public MemberDto(String name, String picUrl, String role){
        this.name = name;
        this.picUrl = picUrl;
        this.role = role;
    }

    public void toMemberDto(Member member){
        this.name = member.getName();
        this.picUrl = member.getPicUrl();
        this.role = member.getRole().toString();
    }
}
