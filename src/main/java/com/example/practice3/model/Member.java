package com.example.practice3.model;

import com.example.practice3.dto.MemberDto;
import com.example.practice3.enums.MemberRole;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class Member {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;

    @Column(name = "Name")
    private String name;

    @Column(name = "Pic_Url")
    private String picUrl;

    @Column(name = "Role")
    private MemberRole role;

    @Builder
    public Member(String name, String picUrl, MemberRole role){
        this.name = name;
        this.picUrl = picUrl;
        this.role = role;
    }

    public MemberDto toMemberDto(Member member){
        return MemberDto.builder()
                .name(member.getName())
                .picUrl(member.getPicUrl())
                .role(member.getRole().toString())
                .build();
    }

    public void update(MemberDto memberDto) {
        this.name = memberDto.getName();
        this.picUrl = memberDto.getPicUrl();
        this.role = MemberRole.valueOf(memberDto.getRole());
    }
}
