package com.jpa.learning.myjpa.controller;


import com.jpa.learning.myjpa.model.Course;
import com.jpa.learning.myjpa.model.Topic;
import com.jpa.learning.myjpa.service.CourseService;
import com.jpa.learning.myjpa.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @RequestMapping("/all")
    public List<Course> getCourses(){
        return  this.courseService.getAllCourse();
    }

    @RequestMapping("/{id}")
    public Course getCourse(@PathVariable("id") int id) {
        return this.courseService.getCourse(id);
    }

    @RequestMapping(value = "/add/{topicId}", method = RequestMethod.POST)
    public String addCourse(@RequestBody Course course, @PathVariable int topicId) {
        return this.courseService.addCourse(course,  topicId);

    }
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public String updateCourse(@RequestBody Course course) {
        return this.courseService.updateCourse(course);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deleteCourse(@PathVariable int id) {
        return this.courseService.deleteCourse(id);
    }
}
