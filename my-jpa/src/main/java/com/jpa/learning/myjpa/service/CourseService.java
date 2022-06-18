package com.jpa.learning.myjpa.service;


import com.jpa.learning.myjpa.Repository.CourseRepository;
import com.jpa.learning.myjpa.Repository.TopicRepository;
import com.jpa.learning.myjpa.model.Course;
import com.jpa.learning.myjpa.model.Topic;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Getter
@Service
@NoArgsConstructor
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;


    public List<Course>  getAllCourse() {
        List<Course> courses = new ArrayList<>();
        courseRepository.findAll().forEach(courses::add);
        return courses;
    }

    public Course getCourse(int id) {
        return courseRepository.findById(id).orElseGet(() -> new Course(id, "Invalid course", null));
    }

    public String  addCourse(Course course, int topicId) {
        course.setTopic(new Topic(topicId, ""));
        courseRepository.save(course);
        return "course added";

    }

    public String updateCourse(Course course) {
        courseRepository.save(course);
        return "course updated";
    }

    public String deleteCourse(int id) {
        courseRepository.deleteById(id );
        return "course deleted";

    }

}
