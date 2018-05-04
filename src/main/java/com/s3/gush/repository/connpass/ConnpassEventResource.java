package com.s3.gush.repository.connpass;

import com.s3.gush.domain.Event;
import com.s3.gush.repository.EventResource;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ConnpassEventResource implements EventResource {
    @Override
    public List<Event> findByKeyword(String keyword) {
        List<Event> events = new ArrayList<>();
        Event event = new Event();
        event.id = "0001";
        event.name = "python2.7";
        events.add(event);
        return events;
    }
}
