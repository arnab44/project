package com.jpa.learning.myjpa.service;


import com.jpa.learning.myjpa.Repository.TopicRepository;
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
public class TopicService {
    @Autowired
    private TopicRepository topicRepository;


    public List<Topic>  getAllTopic() {
        List<Topic> topics = new ArrayList<>();
        topicRepository.findAll().forEach(topics::add);
        return topics;
    }

    public Topic getTopic(int id) {
      //  Optional<Topic> x =  Optional.ofNullable(new Topic(6, "dummy"));
       // String x1 =  x.map(Topic::getName).map(it -> "course:" + it).stream().findFirst()
        return topicRepository.findById(id).orElseGet(() -> new Topic(id, "Invalid course"));
    }

    public String  addTopic(Topic topic) {
        topicRepository.save(topic);
        return "Data saved";

    }

    public String updateTopic(Topic topic) {
        topicRepository.save(topic);
       // topicRepository.
        return "topic updated";
    }

    public String deleteTopic(int id) {
       topicRepository.deleteById(id );
        return "topic deleted";

    }

}
