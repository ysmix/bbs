package com.s3.bbs.model;

import org.seasar.doma.Entity;
import org.seasar.doma.Id;

@Entity
public class Sample {

    @Id
    public String id;

    public String name;

}
