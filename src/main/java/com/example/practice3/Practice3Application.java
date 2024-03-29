package com.example.practice3;

import com.example.practice3.model.Course;
import com.example.practice3.repository.CourseRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class Practice3Application {

    public static void main(String[] args) {
        SpringApplication.run(Practice3Application.class, args);
//        LocalDateTime date = LocalDateTime.parse("2022-07-27", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
//        System.out.println(date);
//        String str = "2021-11-05 13:47:13.248";
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
//        LocalDateTime dateTime = LocalDateTime.parse(str, formatter);
//        System.out.println(dateTime);
    }

    @Bean
    public CommandLineRunner demo(CourseRepository courseRepository){
        return (args)-> {
            String titles = "Spring, React, Nodes.js, Java, Python";
            String tutors = "Emily, Jason, Caroline, Joseph, David";
            String[] titleList = titles.split(",");
            String[] tutorList = tutors.split(",");
            for(int i = 0; i < titleList.length; i++){
                Course course = new Course(titleList[i],tutorList[i]);
                courseRepository.save(course);
            }
//            Course course1 = new Course("Spring","Emily");
//            courseRepository.save(course1);
            List<Course> courseList = courseRepository.findAll();
            for(int n=0;n<courseList.size();n++){
                System.out.println("Title: "+ courseList.get(n).getTitle() + " & Tutor: "
                        +courseList.get(n).getTutor());
            }

        };
    }
}
