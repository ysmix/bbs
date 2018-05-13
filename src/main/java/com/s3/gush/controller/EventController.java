package com.s3.gush.controller;

import com.s3.gush.domain.Event;
import com.s3.gush.service.EventFacadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
@RequestMapping(path = "/event")
@CrossOrigin(origins = "http://localhost:8090")
public class EventController {
    private static final Logger logger = LoggerFactory.getLogger(EventController.class);

    @Autowired
    EventFacadeService eventFacadeService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Event> getEvents(@RequestParam(value = "keyword", required = false) String keyword) {
        logger.info(String.format("Search event keyword : %s", keyword));
        return eventFacadeService.findByKeyword(keyword);
    }
}
