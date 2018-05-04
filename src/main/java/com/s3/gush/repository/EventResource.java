package com.s3.gush.repository;

import com.s3.gush.domain.Event;

import java.util.List;

public interface EventResource {
    List<Event> findByKeyword(String keyword);
}
