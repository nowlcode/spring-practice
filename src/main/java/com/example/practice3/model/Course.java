package com.example.practice3.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Entity
@Getter
public class Course {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable=false)
    private String title;

    @Column(nullable = false)
    private String tutor;


    public Course(String title, String tutor){
        this.title = title;
        this.tutor = tutor;
    }

}
