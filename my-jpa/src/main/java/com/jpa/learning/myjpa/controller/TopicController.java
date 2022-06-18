package com.jpa.learning.myjpa.controller;


import com.jpa.learning.myjpa.model.Topic;
import com.jpa.learning.myjpa.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/topic")
public class TopicController {
    @Autowired
    private TopicService topicService;

    @RequestMapping("/all")
    public List<Topic> getTopics(){
        return  this.topicService.getAllTopic();
    }

    @RequestMapping("/{id}")
    public Topic getTopic(@PathVariable("id") int id) {
        return this.topicService.getTopic(id);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addTopic(@RequestBody Topic topic) {
        return this.topicService.addTopic(topic);

    }
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public String updateTopic(@RequestBody Topic topic) {
        return this.topicService.updateTopic(topic);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deleteTopic(@PathVariable int id) {
        return this.topicService.deleteTopic(id);
    }
}
