package com.s3.gush.service;

import com.s3.gush.domain.Event;
import com.s3.gush.repository.EventResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class EventFacadeService {

    @Autowired
    Map<String, EventResource> eventResourceMap;

    public List<Event> findByKeyword(String keyword) {
        List<Event> events = new ArrayList<>();
        for (Map.Entry<String, EventResource> resourceEntry : eventResourceMap.entrySet()) {
            events.addAll(resourceEntry.getValue().findByKeyword(keyword));
        }
        return events;
    }
}
