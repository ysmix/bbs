package com.s3.gush.controller;


import com.s3.gush.repository.Event;
import com.s3.gush.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/")
public class RootController {

    @Autowired
    EventRepository eventRepository;

    @RequestMapping(method = RequestMethod.GET)
    public List<Event> getEventAll(){
        return eventRepository.getEventAll();
    }
}
