package com.s3.gush.repository;

import org.seasar.doma.Entity;
import org.seasar.doma.Id;

@Entity
public class Event {

    @Id
    public String id;

    public String name;

}
