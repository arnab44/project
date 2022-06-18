package com.example.spring_demo1.service;

import com.example.spring_demo1.model.Student;
import com.example.spring_demo1.model.StudentDTO;
import com.example.spring_demo1.model.Topic;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.stream.Collectors;

@Service
@Getter
public class StudentService {
    private Map topicMapping;
    private List<Student> students;
    @Autowired
    private RestTemplate restTemplate;
    StudentService() {
        this.topicMapping = new HashMap<Integer, List<Integer>>();
        topicMapping.put(101,Arrays.asList(1,3));
        topicMapping.put(102,Arrays.asList(1, 2,3));

        this.students = new ArrayList<Student>(Arrays.asList(new Student(101,"Arnab"), new Student(102, "Swapna"), new Student(103, "Arya")));
    }

    public StudentDTO topicEnrolled(int id) throws Exception {
        List topicIds = (List<Topic>) topicMapping.get(id);
        Student student = null;

        student = students.stream().filter(s -> s.getId() == id).findFirst().orElseThrow(Exception::new);

        List<Topic> topics = new ArrayList<>();
        if(Optional.ofNullable(topicIds).isPresent()) {
            topics = (List<Topic>) Optional.ofNullable(topicIds.
                    stream().
                    map(topicId -> restTemplate.getForObject("http://topic-service/topic/" + topicId, Topic.class))
                    .collect(Collectors.toList())).orElseGet(null);
        }

        return  StudentDTO.builder().id(student.getId())
                .name(student.getName())
                .topicsEnrolled(topics)
                .build();
    }
}
