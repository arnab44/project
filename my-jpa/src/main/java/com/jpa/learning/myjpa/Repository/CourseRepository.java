package com.jpa.learning.myjpa.Repository;

import com.jpa.learning.myjpa.model.Course;
import com.jpa.learning.myjpa.model.Topic;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CourseRepository extends CrudRepository<Course, Integer> {
    public List<Course> findByName(String name);
    public List<Course> findByTopicId(int topicId);
}
