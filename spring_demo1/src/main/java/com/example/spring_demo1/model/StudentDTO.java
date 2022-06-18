package com.example.spring_demo1.model;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentDTO {
    private int id;
    private String name;
    private List<Topic> topicsEnrolled;
}
