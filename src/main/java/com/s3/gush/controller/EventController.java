package com.s3.gush.controller;

import com.s3.gush.domain.Event;
import com.s3.gush.service.EventFacadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping(path = "/event")
public class EventController {
    @Autowired
    EventFacadeService eventFacadeService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Event> getEvents() {
        // TODO:クエリパラメータで受け取れるようにする。
        String keyword = "python";

        return eventFacadeService.findByKeyword(keyword);
    }
}
