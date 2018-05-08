package com.s3.gush.repository.doorkeeper;

import com.s3.gush.domain.Event;
import com.s3.gush.repository.EventResource;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DoorkeeperEventResource implements EventResource {
    @Override
    public List<Event> findByKeyword(String keyword) {
        List<Event> events = new ArrayList<>();
        Event event = new Event();
        event.id = "0002";
        event.title = "java1.8";
        events.add(event);
        return events;
    }
}
