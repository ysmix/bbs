package com.s3.gush.repository;

import com.s3.gush.model.Event;
import org.seasar.doma.Dao;
import org.seasar.doma.Select;
import org.seasar.doma.boot.ConfigAutowireable;

import java.util.List;

@Dao
@ConfigAutowireable
public interface EventRepository {

    @Select
    List<Event> getSampleAll();


}
