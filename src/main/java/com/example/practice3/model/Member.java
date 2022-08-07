package com.example.practice3.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class Member {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long projectMemberId;

    @Column(name = "Name")
    private String name;

    @Column(name = "Pic_Url")
    private String picUrl;

    @Column(name = "Role")
    private MemberRole role;
}
