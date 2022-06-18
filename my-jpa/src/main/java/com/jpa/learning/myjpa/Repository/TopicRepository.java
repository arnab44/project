package com.jpa.learning.myjpa.Repository;

import com.jpa.learning.myjpa.model.Topic;
import org.springframework.data.repository.CrudRepository;

public interface TopicRepository extends CrudRepository<Topic, Integer> {
}
